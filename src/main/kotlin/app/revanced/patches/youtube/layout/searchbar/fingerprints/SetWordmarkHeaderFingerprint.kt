package app.revanced.patches.youtube.layout.searchbar.fingerprints

import app.revanced.patcher.extensions.or
import app.revanced.patcher.fingerprint.method.impl.MethodFingerprint
import org.jf.dexlib2.AccessFlags
import org.jf.dexlib2.Opcode

object SetWordmarkHeaderFingerprint : MethodFingerprint(
    "V", AccessFlags.PUBLIC or AccessFlags.FINAL, listOf("L"),
    opcodes = listOf(
        Opcode.IGET_OBJECT,
        Opcode.INVOKE_STATIC,
        Opcode.MOVE_RESULT,
        Opcode.IF_NEZ,
        Opcode.IGET_BOOLEAN,
        Opcode.IF_EQZ,
        Opcode.IGET_OBJECT,
        Opcode.CONST,
        Opcode.INVOKE_STATIC,
    ),
    customFingerprint = { methodDef, _ -> methodDef.parameterTypes.first() == "Landroid/widget/ImageView;" }
)