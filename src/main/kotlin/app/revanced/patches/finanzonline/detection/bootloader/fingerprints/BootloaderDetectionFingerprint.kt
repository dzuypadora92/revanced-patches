package app.revanced.patches.finanzonline.detection.bootloader.fingerprints

import app.revanced.patcher.fingerprint.method.impl.MethodFingerprint
import org.jf.dexlib2.AccessFlags

object BootloaderDetectionFingerprint : MethodFingerprint(
    "Z",
    accessFlags = AccessFlags.PUBLIC.value,
    strings = listOf("Creation of attestation key succeeded", "Creation of attestation key failed"),
    customFingerprint = { methodDef, _ ->
        methodDef.definingClass.endsWith("/AttestationHelper;")
    }
)
