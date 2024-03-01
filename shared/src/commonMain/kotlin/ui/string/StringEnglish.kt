package ui.string

import const.APP_NAME
import ui.string.Strings.*

fun Strings.en(): String =
    when (this) {
        CommonOkay -> "OK"
        CommonCancel -> "Cancel"
        CommonYes -> "Yes"
        CommonNo -> "No"
        CommonBack -> "Back"
        CommonMore -> "More"
        CommonError -> "Error"
        CommonEdit -> "Edit"
        CommonCheck -> "Check"
        CommonImport -> "Import"
        CommonDoNotShowAgain -> "Do not show again"
        CommonNoMatch -> "No match."
        AlertNeedManualPermissionGrantTitle -> "Permission Required"
        AlertNeedManualPermissionGrantMessage ->
            "The app needs your permission to record audio. Please grant the permission in system settings."
        ErrorReadFileFailedMessage -> "Failed to read file."
        ErrorExportDataFailedMessage -> "Failed to export data."
        ExceptionRenameSessionExisting -> "Session named {0} already exists."
        ExceptionRenameSessionInvalid -> "Invalid session name: {0}"
        ExceptionRenameSessionUnexpected -> "Failed to rename session."
        ExceptionUnsupportedAudioFormat ->
            "Could not find any audio device that supports the current audio format: {0}, " +
                "please check and adjust the audio settings, especially the sample rate and bit depth."
        ExceptionReclistNotFound ->
            "Could not open the session because the reclist ({0}) or its comment file used in this session " +
                "is not found. Please reimport them to use this session."
        AlertExportTips ->
            "Your reclist contains sentences with Japanese voice marked characters " +
                "which will be saved in a special encoding, " +
                "making it unable to be recognized correctly on other platforms, " +
                "due to the specification of MacOS/iOS. " +
                "Before using them on other platforms with other software, " +
                "please normalize the file names to NFC form. " +
                "You can use the \"File Name Normalizer\" tool in the \"Tools\" menu of \"vLabeler\" app to do this."
        AlertExportNoData -> "No data to export"
        ToastExportDataSuccess -> "Exported successfully"
        ToastExportDataCancel -> "Export cancelled"
        ToastImportReclistSuccess -> "Imported successfully"
        ToastImportReclistFailure -> "Failed to import"
        AlertUnexpectedErrorOpenLog -> "An error occurred. Please report to the developer with the error log file."
        AlertUnexpectedErrorOpenLogButton -> "Open Log Folder"
        AlertUnexpectedErrorCopyLogToClipboard ->
            "An error occurred. Please report to the developer with the error info."
        AlertUnexpectedErrorCopyLogToClipboardButton -> "Copy Error Info"
        MainScreenAllSessions -> "Sessions"
        MainScreenNewSession -> "Start New Session"
        MainScreenEmpty -> "No sessions yet."
        MainScreenDeleteItemsTitle -> "Delete Sessions"
        MainScreenDeleteItemsMessage ->
            "Are you sure you want to delete {0} session(s)? The recordings will be completely removed from the device."
        SessionScreenCurrentSentenceLabel -> "Current Recording: "
        SessionScreenCommentEmpty -> "No comment."
        SessionScreenNoData -> "No data."
        SessionScreenActionOpenDirectory -> "Open Directory"
        SessionScreenActionExport -> "Export"
        SessionScreenActionRenameSession -> "Rename Session"
        SessionScreenActionConfigureGuideAudio -> "Configure Guide BGM"
        SessionScreenActionSkipFinishedSentence -> "Skip Recorded Sentences"
        SessionScreenTogglePlaying -> "Toggle Playback"
        SessionScreenNoGuideAudio -> "Not Set"
        SessionScreenAlertGuideAudioNotFoundMessage ->
            "The guide BGM file is not found. Please configure the guide BGM again."
        CreateSessionReclistScreenTitle -> "Select reclist to record"
        CreateSessionReclistScreenActionImport -> "Import Reclist"
        CreateSessionReclistScreenActionImportCommentAlertMessage ->
            "Do you want to import the corresponding comment file (-comment.txt)?"
        CreateSessionReclistScreenAllReclists -> "Reclists"
        CreateSessionReclistScreenEmpty -> "Please import a reclist first."
        CreateSessionReclistScreenContinue -> "Finish"
        CreateSessionReclistScreenFailure -> "Failed to create session."
        CreateSessionReclistScreenDeleteItemsTitle -> "Delete Reclists"
        CreateSessionReclistScreenDeleteItemsMessage -> "Are you sure you want to delete {0} reclist(s)?"
        GuideAudioScreenTitle -> "Configure guide BGM"
        GuideAudioScreenActionImport -> "Import Guide BGM"
        GuideAudioScreenActionImportConfigAlertMessage ->
            "Do you want to import the corresponding guide BGM config file (.txt)?"
        GuideAudioScreenAllGuideAudios -> "Guide BGMs"
        GuideAudioScreenEmpty -> "Please import a guide BGM first."
        GuideAudioScreenDeleteItemsTitle -> "Delete Guide BGMs"
        GuideAudioScreenDeleteItemsMessage -> "Are you sure you want to delete {0} guide BGM(s)?"
        ItemSelectingTitle -> "Selecting {0} items"
        SelectedLabel -> "Selected"
        SearchBar -> "Search"
        SearchBarClear -> "Clear"
        SortingMethod -> "Sorting Method"
        SortingMethodNameAsc -> "Name (Asc)"
        SortingMethodNameDesc -> "Name (Desc)"
        SortingMethodUsedAsc -> "Last Used (Asc)"
        SortingMethodUsedDesc -> "Last Used (Desc)"
        PreferenceScreenTitle -> "Settings"
        PreferenceGroupAppearance -> "Appearance"
        PreferenceLanguage -> "Language"
        PreferenceLanguageAuto -> "Auto"
        PreferenceTheme -> "Theme"
        PreferenceThemeSystem -> "Follow System"
        PreferenceThemeLight -> "Light"
        PreferenceThemeDark -> "Dark"
        PreferenceOrientation -> "Screen Orientation"
        PreferenceOrientationAuto -> "Auto"
        PreferenceOrientationPortrait -> "Portrait"
        PreferenceOrientationLandscape -> "Landscape"
        PreferenceGroupRecording -> "Recording"
        PreferenceContinuousRecording -> "Continuous Recording"
        PreferenceContinuousRecordingDescription -> "Based on the guide BGM"
        PreferenceTrimRecording -> "Trim Recording"
        PreferenceTrimRecordingDescription -> "Based on the guide BGM"
        PreferenceRecordWhileHolding -> "Hold to Record"
        PreferenceRecordingShortKey -> "Shortcut for Recording"
        PreferenceRecordingShortKeyEnter -> "Enter"
        PreferenceRecordingShortKeyR -> "R"
        PreferenceAutoListenBack -> "Auto Listen Back After Recording"
        PreferenceAutoListenBackDescription -> "Unavailable in continuous mode"
        PreferenceAutoNext -> "Auto Go to Next After Recording"
        PreferenceAutoNextDescription -> "Unavailable in continuous mode"
        PreferenceGroupAudio -> "Audio"
        PreferenceInputDeviceName -> "Input Device"
        PreferenceOutputDeviceName -> "Output Device"
        PreferenceSampleRate -> "Sample Rate"
        PreferenceBitDepth -> "Bit Depth"
        PreferenceDeviceNameNotFoundTemplate -> "{0} (Not Found)"
        PreferenceGroupView -> "View"
        PreferenceTitleBarStyle -> "Title Bar Style"
        PreferenceTitleBarStyleFileName -> "Only File Name"
        PreferenceTitleBarStyleFileNameWithComment -> "File Name with Comment (small)"
        PreferenceTitleBarStyleCommentWithFileName -> "Comment with File Name (small)"
        PreferenceTitleBarStyleComment -> "Only Comment"
        PreferenceGroupMisc -> "Misc"
        PreferenceContentRootLocation -> "Location of Content Directory"
        PreferenceAbout -> "About $APP_NAME"
        AboutScreenPrivacyPolicy -> "Privacy Policy"
        AboutScreenCopyDeviceInfo -> "Copy Device Info"
        AboutScreenDeviceInfoCopied -> "Device info copied to clipboard"
        AboutScreenViewLicenses -> "View Licenses"
        AboutScreenViewOnGithub -> "View on GitHub"
        LicenseScreenTitle -> "Licenses"
        MenuFile -> "File"
        MenuFileNewSession -> "Start New Session"
        MenuFileImportReclist -> "Import Reclist"
        MenuFileImportGuideAudio -> "Import Guide BGM"
        MenuFileOpenDirectory -> "Open Directory"
        MenuFileBack -> "Back"
        MenuEdit -> "Edit"
        MenuEditRenameSession -> "Rename Session"
        MenuEditConfigureGuideAudio -> "Configure Guide BGM"
        MenuEditEditList -> "Edit List"
        MenuAction -> "Action"
        MenuActionNextSentence -> "Next Sentence"
        MenuActionPreviousSentence -> "Previous Sentence"
        MenuActionToggleRecording -> "Toggle Recording"
        MenuActionToggleRecordingHoldingMode -> "Toggle Recording (Only shortcut is available)"
        MenuSettings -> "Settings"
        MenuSettingsOpenSettings -> "Open Settings"
        MenuSettingsClearSettings -> "Clear Settings"
        MenuSettingsClearSettingsAlertMessage ->
            "Are you sure you want to clear all settings? This will not delete your sessions and imported resources. " +
                "The App will be closed after clearing."
        MenuHelp -> "Help"
        MenuHelpOpenContentDirectory -> "Open Content Directory"
        MenuHelpOpenAppDirectory -> "Open App Directory"
        MenuHelpAbout -> "About"
    }
