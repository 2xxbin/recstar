package ui.screen

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.ContentAlpha
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Circle
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.NavigateBefore
import androidx.compose.material.icons.filled.NavigateNext
import androidx.compose.material.icons.filled.Square
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.ExportDataRequest
import io.LocalFileInteractor
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import model.Session
import ui.common.LocalAlertDialogController
import ui.common.LocalProgressController
import ui.common.ReversedRow
import ui.common.ScrollableLazyColumn
import ui.common.plainClickable
import ui.common.requestInput
import ui.model.LocalScreenOrientation
import ui.model.Screen
import ui.model.ScreenOrientation
import ui.model.Sentence
import ui.string.*
import ui.style.CustomColors
import util.alpha
import util.isDesktop
import util.isIos
import util.isMobile

data class SessionScreen(val initialSession: Session) : Screen {
    @Composable
    override fun getTitle(): String = rememberSessionScreenModel(initialSession).name

    @Composable
    override fun Actions() = ScreenActions()

    @Composable
    override fun Content() = ScreenContent()
}

@Composable
private fun SessionScreen.ScreenActions() {
    var showMenu by remember { mutableStateOf(false) }
    val model = rememberSessionScreenModel(initialSession)
    IconButton(
        enabled = model.isRecording.not() && model.isBusy.not(),
        onClick = { showMenu = !showMenu },
    ) {
        Icon(
            imageVector = Icons.Default.MoreVert,
            contentDescription = string(Strings.CommonMore),
        )
    }
    DropdownMenu(
        expanded = showMenu,
        onDismissRequest = { showMenu = false },
    ) {
        val fileInteractor = LocalFileInteractor.current
        val progressController = LocalProgressController.current
        val alertDialogController = LocalAlertDialogController.current
        val useOpenDirectory = isDesktop || isIos
        val useExport = isMobile
        if (useOpenDirectory) {
            DropdownMenuItem(
                onClick = {
                    showMenu = false
                    fileInteractor.requestOpenFolder(model.contentDirectory)
                },
            ) {
                Text(text = string(Strings.SessionScreenActionOpenDirectory))
            }
        }
        if (useExport) {
            DropdownMenuItem(
                onClick = {
                    showMenu = false
                    val request = ExportDataRequest(
                        folder = model.contentDirectory,
                        allowedExtension = listOf("wav"),
                        onStart = { progressController.show() },
                        onSuccess = { progressController.hide() },
                        onCancel = { progressController.hide() },
                        onError = { progressController.hide() },
                    )
                    fileInteractor.exportData(request)
                },
            ) {
                Text(text = string(Strings.SessionScreenActionExport))
            }
        }
        DropdownMenuItem(
            onClick = {
                showMenu = false
                alertDialogController.requestInput(
                    title = stringStatic(Strings.SessionScreenActionRenameSession),
                    initialValue = model.name,
                    selected = true,
                    onConfirmInput = model::renameSession,
                )
            },
        ) {
            Text(text = string(Strings.SessionScreenActionRenameSession))
        }
    }
}

@Composable
private fun SessionScreen.ScreenContent() {
    val model = rememberSessionScreenModel(initialSession)
    val screenOrientation = LocalScreenOrientation.current
    if (screenOrientation == ScreenOrientation.Landscape) {
        Row(modifier = Modifier.fillMaxSize()) {
            Box(modifier = Modifier.weight(0.3f).fillMaxHeight()) {
                SentenceList(model)
            }
            Box(
                modifier = Modifier.width(1.dp)
                    .fillMaxHeight()
                    .background(color = MaterialTheme.colors.background.alpha(0.5f)),
            )
            Box(modifier = Modifier.weight(0.7f).fillMaxHeight()) {
                Recorder(model, hasFixedHeight = true)
            }
        }
    } else {
        Column(modifier = Modifier.fillMaxSize()) {
            Box(modifier = Modifier.weight(1f).fillMaxWidth()) {
                SentenceList(model)
            }
            Box(
                modifier = Modifier.height(1.dp)
                    .fillMaxWidth()
                    .background(color = MaterialTheme.colors.background.alpha(0.5f)),
            )
            Box(modifier = Modifier.fillMaxWidth()) {
                Recorder(model, hasFixedHeight = false)
            }
        }
    }
}

private val itemHeight = 32.dp

@Composable
private fun SentenceList(model: SessionScreenModel) {
    val lazyListState = rememberLazyListState()
    val density = LocalDensity.current
    val itemHeightPx = remember(density) { with(density) { itemHeight.toPx() } }
    LaunchedEffect(Unit) {
        model.requestScrollToCurrentSentenceFlow.collectLatest {
            val targetOffset = with(lazyListState.layoutInfo) {
                (viewportEndOffset + viewportStartOffset) / 2
            }
            val additionalOffset = (targetOffset - itemHeightPx / 2).toInt()
            lazyListState.animateScrollToItem(
                index = model.currentIndex,
                scrollOffset = -additionalOffset,
            )
        }
    }
    ScrollableLazyColumn(
        modifier = Modifier.fillMaxSize(),
        lazyListState = lazyListState,
    ) {
        itemsIndexed(
            model.sentences,
            key = { index, _ -> index },
        ) { index, sentence ->
            SentenceItem(
                index = index,
                sentence = sentence,
                isCurrent = model.currentIndex == index,
                onClickItem = model::selectSentence,
            )
        }
    }
}

@Composable
private fun SentenceItem(
    index: Int,
    sentence: Sentence,
    isCurrent: Boolean,
    onClickItem: (index: Int) -> Unit,
) {
    ReversedRow(
        modifier = Modifier.fillMaxWidth()
            .height(itemHeight)
            .background(color = if (isCurrent) MaterialTheme.colors.primary else Color.Transparent)
            .plainClickable { onClickItem(index) }
            .padding(horizontal = 32.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        if (sentence.isFinished) {
            Icon(
                modifier = Modifier.size(16.dp),
                imageVector = Icons.Filled.CheckCircle,
                contentDescription = null,
                tint = if (isCurrent) MaterialTheme.colors.onPrimary else CustomColors.DarkGreen,
            )
            Spacer(modifier = Modifier.width(4.dp))
        }
        Text(
            modifier = Modifier.weight(1f),
            text = sentence.text,
            style = MaterialTheme.typography.body2,
            color = if (isCurrent) MaterialTheme.colors.onPrimary else MaterialTheme.colors.onBackground,
            overflow = TextOverflow.Ellipsis,
            maxLines = 1,
        )
    }
}

@Composable
private fun Recorder(
    model: SessionScreenModel,
    hasFixedHeight: Boolean,
) {
    Column(modifier = Modifier.fillMaxWidth().background(color = MaterialTheme.colors.background)) {
        RecorderTitleBar(model)
        Box(
            modifier = Modifier.fillMaxWidth()
                .run {
                    if (hasFixedHeight) {
                        weight(1f)
                    } else {
                        aspectRatio(3f)
                    }
                },
        ) {
            RecorderWaveform(
                hasFile = model.currentSentence.isFinished,
                isRecording = model.isRecording,
                flow = model.waveformFlow,
            )
        }
        Box(
            modifier = Modifier.fillMaxWidth()
                .aspectRatio(
                    if (LocalScreenOrientation.current == ScreenOrientation.Landscape) 5f else 3f,
                ),
        ) {
            RecorderControls(
                isInteractionSuspended = model.isBusy,
                isRecording = model.isRecording,
                onToggleRecording = model::toggleRecording,
                hasNext = model.hasNext,
                onNext = model::next,
                hasPrevious = model.hasPrevious,
                onPrevious = model::previous,
            )
        }
    }
}

@Composable
private fun RecorderTitleBar(model: SessionScreenModel) {
    val useSmallSizes = isMobile && LocalScreenOrientation.current == ScreenOrientation.Landscape
    Spacer(modifier = Modifier.height(if (useSmallSizes) 12.dp else 24.dp))
    Text(
        text = string(Strings.SessionScreenCurrentSentenceLabel),
        modifier = Modifier.padding(horizontal = 32.dp),
        style = MaterialTheme.typography.overline,
        fontSize = if (useSmallSizes) 8.sp else MaterialTheme.typography.overline.fontSize,
    )
    Text(
        text = model.currentSentence.text,
        modifier = Modifier.padding(horizontal = 32.dp),
        style = if (useSmallSizes) MaterialTheme.typography.h6 else MaterialTheme.typography.h4,
        overflow = TextOverflow.Ellipsis,
        maxLines = 1,
    )
    Spacer(modifier = Modifier.height(if (useSmallSizes) 12.dp else 24.dp))
}

@Composable
private fun RecorderWaveform(
    hasFile: Boolean,
    isRecording: Boolean,
    flow: Flow<Array<FloatArray>>,
) {
    val isDarkMode = isSystemInDarkTheme()
    val paperColor = if (isDarkMode) Color.Black else Color.White
    Box(modifier = Modifier.fillMaxSize().background(color = paperColor)) {
        if (!hasFile && !isRecording) {
            Text(
                text = string(Strings.SessionScreenNoData),
                style = MaterialTheme.typography.caption,
                color = MaterialTheme.colors.onBackground,
                modifier = Modifier.align(Alignment.Center),
            )
        }
        val data by flow.collectAsState(initial = emptyArray())
        val color = if (isRecording) MaterialTheme.colors.secondary else MaterialTheme.colors.primary
        Canvas(modifier = Modifier.fillMaxSize()) {
            val width = size.width.toInt()
            val height = size.height.toInt()
            val halfHeight = height / 2
            val dataLength = data.size
            val ratio = (dataLength.toFloat() / width).coerceAtLeast(1f)
            val offset = (dataLength - width).coerceAtMost(0)
            for (i in 0 until width) {
                val x = i.toFloat()
                val dataPosStart = (i * ratio).toInt() + offset
                val dataPosEnd = ((i + 1) * ratio).toInt() + offset
                if (dataPosStart < 0 || dataPosStart >= dataLength ||
                    dataPosEnd - 1 < 0 || dataPosEnd - 1 >= dataLength
                ) {
                    continue
                }
                val dataInPoint = data.copyOfRange(dataPosStart, dataPosEnd)
                val max = dataInPoint.maxOfOrNull { it[0] } ?: continue
                val min = dataInPoint.minOfOrNull { it[1] } ?: continue
                val maxY = max * halfHeight
                val minY = min * halfHeight
                drawLine(
                    color = color,
                    start = Offset(x, halfHeight + maxY),
                    end = Offset(x, halfHeight + minY),
                )
            }
        }
    }
}

@Composable
private fun RecorderControls(
    isInteractionSuspended: Boolean,
    isRecording: Boolean,
    onToggleRecording: () -> Unit,
    hasNext: Boolean,
    onNext: () -> Unit,
    hasPrevious: Boolean,
    onPrevious: () -> Unit,
) {
    Row(
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        NavigateButton(
            isInteractionSuspended = isInteractionSuspended,
            onClick = onPrevious,
            enabled = hasPrevious,
            imageVector = Icons.Default.NavigateBefore,
            contentDescription = "",
        )
        Spacer(modifier = Modifier.width(48.dp))
        RecordButton(
            isInteractionSuspended = isInteractionSuspended,
            isRecording = isRecording,
            onToggleRecording = onToggleRecording,
        )
        Spacer(modifier = Modifier.width(48.dp))
        NavigateButton(
            isInteractionSuspended = isInteractionSuspended,
            onClick = onNext,
            enabled = hasNext,
            imageVector = Icons.Default.NavigateNext,
            contentDescription = "",
        )
    }
}

@Composable
private fun RecordButton(
    isInteractionSuspended: Boolean,
    isRecording: Boolean,
    onToggleRecording: () -> Unit,
) {
    Box(
        modifier = Modifier.fillMaxHeight(0.55f)
            .aspectRatio(1f, matchHeightConstraintsFirst = true)
            .plainClickable {
                if (!isInteractionSuspended) {
                    onToggleRecording()
                }
            },
    ) {
        Crossfade(targetState = isRecording) { isRecording ->
            val imageVector = if (isRecording) Icons.Filled.Square else Icons.Filled.Circle
            val sizeFraction = if (isRecording) 0.7f else 1f
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center,
            ) {
                Icon(
                    modifier = Modifier.fillMaxSize(sizeFraction),
                    imageVector = imageVector,
                    contentDescription = "",
                    tint = MaterialTheme.colors.error,
                )
            }
        }
    }
}

@Composable
private fun NavigateButton(
    isInteractionSuspended: Boolean,
    onClick: () -> Unit,
    enabled: Boolean,
    imageVector: ImageVector,
    contentDescription: String,
) {
    IconButton(
        modifier = Modifier.fillMaxHeight(0.4f)
            .aspectRatio(1f, matchHeightConstraintsFirst = true),
        onClick = {
            if (!isInteractionSuspended) {
                onClick()
            }
        },
        enabled = enabled,
    ) {
        CompositionLocalProvider(
            LocalContentAlpha provides if (enabled) ContentAlpha.high else ContentAlpha.disabled,
        ) {
            Icon(
                modifier = Modifier.fillMaxSize(),
                imageVector = imageVector,
                contentDescription = contentDescription,
            )
        }
    }
}
