#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring JNICALL
Java_com_example_corelib_NativeLib_stringFromJNI(
        JNIEnv* env,
        jobject /* this */) {
    std::string hello = "Hello from Corelib C++ native library";
    return env->NewStringUTF(hello.c_str());
}

extern "C" JNIEXPORT jintArray JNICALL
Java_com_example_corelib_NativeLib_sort(JNIEnv* env, jobject thisObject, jintArray arr) {
    int size = (env)->GetArrayLength(arr);

    jintArray result;
    result = (env)->NewIntArray(size);
    if (result == NULL) {
        return NULL;
    }

    jint *arrTmp = (env)->GetIntArrayElements(arr, NULL);
    jint tmp;

    for (int i = 0; i < size; i++) {
       for (int j = i+1; j < size; j++) {
           if (arrTmp[i] > arrTmp[j]) {
               tmp = arrTmp[j];
               arrTmp[j] = arrTmp[i];
               arrTmp[i] = tmp;
           }
       }
    }

    (env)->SetIntArrayRegion(result, 0, size, arrTmp);

    return result;
}