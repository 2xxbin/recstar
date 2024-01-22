package ui.string

import const.APP_NAME
import ui.string.Strings.*

@Suppress("REDUNDANT_ELSE_IN_WHEN")
fun Strings.ja(): String? =
    when (this) {
        CommonOkay -> "OK"
        CommonCancel -> "キャンセル"
        CommonYes -> "はい"
        CommonNo -> "いいえ"
        CommonBack -> "戻る"
        CommonMore -> "その他"
        CommonError -> "エラー"
        CommonEdit -> "編集"
        CommonCheck -> "選択"
        CommonImport -> "インポート"
        AlertNeedManualPermissionGrantTitle -> "権限が必要です"
        AlertNeedManualPermissionGrantMessage -> "アプリは音声を録音するために権限が必要です。システム設定で権限を許可してください。"
        ErrorReadFileFailedMessage -> "ファイルの読み込みに失敗しました。"
        ErrorExportDataFailedMessage -> "データのエクスポートに失敗しました。"
        ExceptionRenameSessionExisting -> "名前が {0} のセッションが既に存在します。"
        ExceptionRenameSessionInvalid -> "無効なセッション名：{0}"
        ExceptionRenameSessionUnexpected -> "セッション名の編集に失敗しました。"
        AlertExportTips ->
            "iOS や macOS で録音したファイルには、ファイル名が特殊文字を含む場合があります。" +
                "Windows 上の他のソフトウェアでこれらのファイルを使用する前に、ファイル名を NFC 形式に正規化してください。" +
                "これは、`vLabeler` アプリの「ツール」メニューの「ファイル名を正規化」ツールで実行できます。"
        ToastExportDataSuccess -> "成功しました"
        ToastExportDataCancel -> "キャンセルされました"
        ToastImportReclistSuccess -> "インポートに成功しました"
        ToastImportReclistFailure -> "インポートに失敗しました"
        AlertUnexpectedErrorOpenLog -> "エラーが発生しました。エラーログファイルを添付し、開発者に報告してください。"
        AlertUnexpectedErrorOpenLogButton -> "ログフォルダを開く"
        AlertUnexpectedErrorCopyLogToClipboard -> "エラーが発生しました。エラー情報を添付し、開発者に報告してください。"
        AlertUnexpectedErrorCopyLogToClipboardButton -> "エラー情報をコピー"
        MainScreenAllSessions -> "すべてのセッション"
        MainScreenItemSelecting -> "{0} 件選択"
        MainScreenNewSession -> "新しいセッションを開始"
        MainScreenEmpty -> "セッションがありません。"
        MainScreenDeleteItemsTitle -> "セッションを削除"
        MainScreenDeleteItemsMessage -> "本当に {0} 件のセッションを削除しますか？録音ファイルは完全に削除されます。"
        SessionScreenCurrentSentenceLabel -> "録音中："
        SessionScreenCommentEmpty -> "コメントがありません。"
        SessionScreenNoData -> "データがありません。"
        SessionScreenActionOpenDirectory -> "ディレクトリを開く"
        SessionScreenActionExport -> "エクスポート"
        SessionScreenActionRenameSession -> "セッション名を編集"
        SessionScreenActionConfigureGuideAudio -> "ガイド BGM を設定"
        SessionScreenActionSkipFinishedSentence -> "録音済みの行をスキップ"
        SessionScreenTogglePlaying -> "再生/停止"
        SessionScreenNoGuideAudio -> "未設定"
        SessionScreenAlertGuideAudioNotFoundMessage -> "ガイド BGM ファイルが見つかりません。ガイド BGM を再設定してください。"
        CreateSessionReclistScreenTitle -> "録音リストを選択"
        CreateSessionReclistScreenActionImport -> "録音リストをインポート"
        CreateSessionReclistScreenActionImportCommentAlertMessage ->
            "続いてコメントファイル（-comment.txt）をインポートしますか？"
        CreateSessionReclistScreenAllReclists -> "すべての録音リスト"
        CreateSessionReclistScreenEmpty -> "録音リストをインポートしてください。"
        CreateSessionReclistScreenContinue -> "完了"
        CreateSessionReclistScreenFailure -> "セッションの作成に失敗しました。"
        CreateSessionReclistScreenDeleteItemsTitle -> "録音リストを削除"
        CreateSessionReclistScreenDeleteItemsMessage -> "本当に {0} 件の録音リストを削除しますか？"
        GuideAudioScreenTitle -> "ガイド BGM を設定"
        GuideAudioScreenActionImport -> "ガイド BGM をインポート"
        GuideAudioScreenActionImportConfigAlertMessage -> "続いてガイド BGM の設定ファイル（.txt）をインポートしますか？"
        GuideAudioScreenAllGuideAudios -> "すべてのガイド BGM"
        GuideAudioScreenEmpty -> "ガイド BGM をインポートしてください。"
        GuideAudioScreenItemSelectedLabel -> "選択済み"
        GuideAudioScreenDeleteItemsTitle -> "ガイド BGM を削除"
        GuideAudioScreenDeleteItemsMessage -> "本当に {0} 件のガイド BGM を削除しますか？"
        SortingMethod -> "並び替え"
        SortingMethodNameAsc -> "名称（昇順）"
        SortingMethodNameDesc -> "名称（降順）"
        SortingMethodUsedAsc -> "使用日時（昇順）"
        SortingMethodUsedDesc -> "使用日時（降順）"
        PreferenceScreenTitle -> "設定"
        PreferenceGroupAppearance -> "外観"
        PreferenceLanguage -> "言語"
        PreferenceLanguageAuto -> "自動"
        PreferenceTheme -> "テーマ"
        PreferenceThemeSystem -> "システムに従う"
        PreferenceThemeLight -> "ライト"
        PreferenceThemeDark -> "ダーク"
        PreferenceOrientation -> "画面の向き"
        PreferenceOrientationAuto -> "自動"
        PreferenceOrientationPortrait -> "縦向き"
        PreferenceOrientationLandscape -> "横向き"
        PreferenceGroupRecording -> "録音"
        PreferenceContinuousRecording -> "連続録音"
        PreferenceContinuousRecordingDescription -> "ガイド BGM に基づく"
        PreferenceTrimRecording -> "録音をトリミング"
        PreferenceTrimRecordingDescription -> "ガイド BGM に基づく"
        PreferenceRecordWhileHolding -> "押下中に録音"
        PreferenceRecordingShortKey -> "録音のショートカット"
        PreferenceRecordingShortKeyEnter -> "Enter"
        PreferenceRecordingShortKeyR -> "R"
        PreferenceAutoListenBack -> "録音後に自動で再生"
        PreferenceAutoListenBackDescription -> "連続録音モードでは無効"
        PreferenceAutoNext -> "録音後に自動で次の行に移動"
        PreferenceAutoNextDescription -> "連続録音モードでは無効"
        PreferenceGroupAudio -> "音声"
        PreferenceInputDeviceName -> "入力デバイス"
        PreferenceInputDeviceNameNotFoundTemplate -> "{0}（不明）"
        PreferenceGroupView -> "表示"
        PreferenceTitleBarStyle -> "タイトルバーのスタイル"
        PreferenceTitleBarStyleFileName -> "ファイル名のみ"
        PreferenceTitleBarStyleFileNameWithComment -> "ファイル名 + コメント（小）"
        PreferenceTitleBarStyleCommentWithFileName -> "コメント + ファイル名（小）"
        PreferenceTitleBarStyleComment -> "コメントのみ"
        PreferenceGroupMisc -> "その他"
        PreferenceContentRootLocation -> "コンテンツディレクトリのローケーション"
        AboutScreenPrivacyPolicy -> "プライバシーポリシー"
        PreferenceAbout -> "$APP_NAME について"
        AboutScreenCopyDeviceInfo -> "デバイス情報をコピー"
        AboutScreenDeviceInfoCopied -> "コピーしました"
        AboutScreenViewOnGithub -> "GitHub で表示"
        MenuFile -> "ファイル"
        MenuFileNewSession -> "新しいセッションを開始"
        MenuFileImportReclist -> "録音リストをインポート"
        MenuFileImportGuideAudio -> "ガイド BGM をインポート"
        MenuFileOpenDirectory -> "ディレクトリを開く"
        MenuFileBack -> "戻る"
        MenuEdit -> "編集"
        MenuEditRenameSession -> "セッション名を編集"
        MenuEditConfigureGuideAudio -> "ガイド BGM を設定"
        MenuEditEditList -> "リストを編集"
        MenuAction -> "操作"
        MenuActionNextSentence -> "次へ"
        MenuActionPreviousSentence -> "前へ"
        MenuActionToggleRecording -> "録音/停止"
        MenuActionToggleRecordingHoldingMode -> "録音/停止（ショートカットのみ有効）"
        MenuSettings -> "設定"
        MenuSettingsOpenSettings -> "設定を開く"
        MenuSettingsClearSettings -> "設定をクリア"
        MenuSettingsClearSettingsAlertMessage ->
            "すべての設定をクリアしますか？セッションデータやインポートしたリソースファイル（録音リストやガイド BGM など）は削除されません。" +
                "アプリはこの操作後に終了します。"
        MenuHelp -> "ヘルプ"
        MenuHelpOpenContentDirectory -> "コンテンツディレクトリを開く"
        MenuHelpOpenAppDirectory -> "アプリディレクトリを開く"
        MenuHelpAbout -> "$APP_NAME について"
        else -> null
    }
