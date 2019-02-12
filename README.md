# Bsdiff
一个文件差分框架，将之前使用ndk build编译的方式更换为CMake

### 差分操作
```
/**
 * 第一个参数为旧版本apk文件路径
 * 第二个参数为新版本apk文件路径
 * 第三个参数为生成的差分包文件路径
 */
Bsdiff.onBsdiff(mApkOldPath, mApkNewPath, mPatchPath)
```

### 合并操作
```
/**
 * 第一个参数为旧版本apk文件路径
 * 第二个参数为将旧版本apk文件和差分包文件合并之后生成的新版本apk文件路径
 * 第三个参数为生成的差分包文件路径
 */
Bspatch.onBspatch(mApkOldPath, mApkInstallPath, mPatchPath)
```
