import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import ui.common.OpenFileDialog
import ui.common.OpenFileDialogRequest
import ui.common.SaveFileDialog
import ui.common.SaveFileDialogRequest
import ui.model.DesktopContext
import ui.model.LocalScreenOrientation
import ui.model.ScreenOrientation

@Composable
fun MainView() {
    val coroutineScope = rememberCoroutineScope()
    val context = remember { DesktopContext(coroutineScope) }
    val dependencies = remember(context) { AppDependencies(context) }
    ProvideAppDependencies(dependencies) {
        CompositionLocalProvider(LocalScreenOrientation provides ScreenOrientation.Landscape) {
            // Currently always use landscape orientation on desktop
            // Later we could use the window size or some settings to determine the orientation
            App()
            dependencies.fileInteractor.fileDialogRequest?.let {
                when (it) {
                    is OpenFileDialogRequest -> OpenFileDialog(it)
                    is SaveFileDialogRequest -> SaveFileDialog(it)
                }
            }
        }
    }
}
