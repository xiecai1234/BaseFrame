#所有gson对应实体类不能混淆
-keep class com.mobile.wx.bean.http.** {*;}

-keep class android.support.v4.content.** { *; }
-keep interface android.support.v4.content.** { *; }
-keep class android.support.v4.content.FileProvider{*;}
-keep class android.content.pm.ProviderInfo{*;}
-keep class android.content.pm.PackageManager{*;}
-keep class android.os.Build{*;}
-keep class android.os.Build$*{*;}
-keep class android.os.**{*;}
-keep class android.**{*;}
-keep class java.**{*;}
-keep class javax.**{*;}

#保留 bean包下的类及类的成员，因为要保存到文件再读取
-keep class com.xafk.wxcoredata.*{*;}