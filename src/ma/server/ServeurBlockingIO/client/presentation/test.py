
// WARNING: Could not reconcile some variable overlaps
// WARNING: [rz-ghidra] Detected overlap for variable var_94h
// WARNING: [rz-ghidra] Detected overlap for variable var_bch
// WARNING: [rz-ghidra] Detected overlap for variable var_b8h
// WARNING: [rz-ghidra] Detected overlap for variable var_b4h
// WARNING: [rz-ghidra] Detected overlap for variable var_b0h
// WARNING: [rz-ghidra] Detected overlap for variable var_ach
// WARNING: [rz-ghidra] Detected overlap for variable var_d0h
// WARNING: [rz-ghidra] Detected overlap for variable var_c4h
// WARNING: [rz-ghidra] Detected overlap for variable var_d5h
// WARNING: [rz-ghidra] Detected overlap for variable var_cch

undefined8 main(void)
{
    uint64_t uVar1;
    int64_t iVar2;
    undefined8 uVar3;
    int64_t in_FS_OFFSET;
    int64_t Itr1;
    int32_t var_cch;
    int64_t var_c8h;
    int64_t var_c0h;
    int32_t var_b8h [4];
    char *var_a8h;
    int64_t var_a0h;
    int64_t var_98h;
    int64_t var_88h;
    char *s;
    int64_t canary;
    
    canary = *(int64_t *)(in_FS_OFFSET + 0x28);
    var_a8h = (char *)0x4463457d4f625f68;
    var_a0h = 0x28687529472b524f;
    var_98h._0_4_ = 0x762c6c6a;
    var_98h._4_1_ = 0x4c;
    printf(0xa98);
    __isoc99_scanf(0xadd, &s);
    var_c0h._0_4_ = 0x10;
    var_c0h._4_4_ = 0x18;
    uVar1 = strlen(&s);
    var_b8h[0] = (int32_t)(uVar1 >> 1);
    var_b8h[1] = strlen(&s);
    var_b8h[2] = 0;
    uVar1 = strlen(&s);
    var_b8h[3] = (int32_t)(uVar1 >> 1);
    for (i= 0; (int32_t)i < 2; i= (int32_t)i + 1) {
        for (j = var_b8h[(int64_t)(int32_t)i + 2]; j < var_b8h[(int32_t)i];j = j + 1) {
    
                 var_88h[j] = s[j] ^ (uint8_t)var_c0h[(int64_t)(int32_t)i * 2];

        }
    }
    var_cch = 0;
    while( true ) {
        iVar2 = strlen(&var_a8h);
        if (iVar2 - 1 <= (uint64_t)(int64_t)var_cch) break;
        if (*(char *)var_88h[var_cch] != *(char *)var_a8h[var_cch]) {
            puts(0xae0);
            exit(0);
        }
        var_cch = var_cch + 1;
    }
    puts(0xaf3);
    uVar3 = 0;
    if (canary != *(int64_t *)(in_FS_OFFSET + 0x28)) {
        uVar3 = __stack_chk_fail();
    }
    return uVar3;
}
