package app.revanced.patches.trakt.fingerprints

import app.revanced.patcher.fingerprint.method.impl.MethodFingerprint

object IsVIPEPFingerprint : MethodFingerprint(
    customFingerprint = custom@{ methodDef, _ ->
        if (!methodDef.definingClass.endsWith("RealmUserSettings;")) return@custom false

        methodDef.name == "isVIPEP"
    }
)