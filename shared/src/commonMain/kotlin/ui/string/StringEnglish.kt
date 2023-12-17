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
        AlertNeedManualPermissionGrantTitle -> "Permission Required"
        AlertNeedManualPermissionGrantMessage ->
            "The app needs your permission to record audio. Please grant the permission in system settings."
        ErrorReadFileFailedMessage -> "Failed to read file."
        ErrorExportDataFailedMessage -> "Failed to export data."
        ExceptionRenameSessionExisting -> "Session named {0} already exists."
        ExceptionRenameSessionInvalid -> "Invalid session name: {0}"
        ExceptionRenameSessionUnexpected -> "Failed to rename session."
        ToastExportDataSuccess -> "Exported successfully"
        ToastExportDataCancel -> "Export cancelled"
        ToastImportReclistSuccess -> "Imported successfully"
        ToastImportReclistFailure -> "Failed to import"
        MainScreenAllSessions -> "All Sessions"
        MainScreenItemSelecting -> "Selecting {0} items"
        MainScreenNewSession -> "Start New Session"
        MainScreenEmpty -> "No sessions yet."
        MainScreenDeleteItemsTitle -> "Delete Sessions"
        MainScreenDeleteItemsMessage ->
            "Are you sure you want to delete {0} session(s)? The recordings will be completely removed from the device."
        SessionScreenCurrentSentenceLabel -> "Current Recording: "
        SessionScreenNoData -> "No data."
        SessionScreenActionOpenDirectory -> "Open Directory"
        SessionScreenActionExport -> "Export"
        SessionScreenActionRenameSession -> "Rename Session"
        SessionScreenActionConfigureGuideAudio -> "Configure Guide BGM"
        SessionScreenTogglePlaying -> "Toggle Playback"
        SessionScreenNoGuideAudio -> "Not Set"
        SessionScreenAlertGuideAudioNotFoundMessage ->
            "The guide BGM file is not found. Please configure the guide BGM again."
        CreateSessionReclistScreenTitle -> "Select reclist to record"
        CreateSessionReclistScreenActionImport -> "Import Reclist"
        CreateSessionReclistScreenAllReclists -> "All Reclists"
        CreateSessionReclistScreenEmpty -> "Please import a reclist first."
        CreateSessionReclistScreenContinue -> "Finish"
        CreateSessionReclistScreenFailure -> "Failed to create session."
        CreateSessionReclistScreenDeleteItemsTitle -> "Delete Reclists"
        CreateSessionReclistScreenDeleteItemsMessage -> "Are you sure you want to delete {0} reclist(s)?"
        GuideAudioScreenTitle -> "Configure guide BGM"
        GuideAudioScreenActionImport -> "Import Guide BGM"
        GuideAudioScreenActionImportConfigAlertMessage ->
            "Do you want to import the corresponding guide BGM config file (.txt)?"
        GuideAudioScreenAllGuideAudios -> "All Guide BGMs"
        GuideAudioScreenEmpty -> "Please import a guide BGM first."
        GuideAudioScreenItemSelectedLabel -> "Selected"
        GuideAudioScreenDeleteItemsTitle -> "Delete Guide BGMs"
        GuideAudioScreenDeleteItemsMessage -> "Are you sure you want to delete {0} guide BGM(s)?"
        PreferenceScreenTitle -> "Settings"
        PreferenceGroupAppearance -> "Appearance"
        PreferenceLanguage -> "Language"
        PreferenceLanguageAuto -> "Auto"
        PreferenceTheme -> "Theme"
        PreferenceThemeSystem -> "Follow System"
        PreferenceThemeLight -> "Light"
        PreferenceThemeDark -> "Dark"
        PreferenceGroupRecording -> "Recording"
        PreferenceContinuousRecording -> "Continuous recording"
        PreferenceContinuousRecordingDescription -> "Based on the guide BGM"
        PreferenceGroupReclist -> "Reclist"
        PreferenceKanaNormalization -> "Normalize Kana"
        PreferenceKanaNormalizationDescription -> "Use NFC kana for the saved audio"
        PreferenceGroupMisc -> "Misc"
        PreferenceContentRootLocation -> "Location of Content Directory"
        PreferenceAbout -> "About $APP_NAME"
        AboutScreenPrivacyPolicy -> "Privacy Policy"
        AboutScreenCopyDeviceInfo -> "Copy Device Info"
        AboutScreenDeviceInfoCopied -> "Device info copied to clipboard"
        AboutScreenViewOnGithub -> "View on GitHub"
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
