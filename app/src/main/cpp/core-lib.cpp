#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring JNICALL
Java_com_example_hello_1cmake_MainActivity_testFromCore(JNIEnv* env, jobject thiz) {
    std::string test = "Call from core lib";
    return env->NewStringUTF(test.c_str());
}

extern "C" JNIEXPORT jdouble JNICALL
Java_com_example_hello_1cmake_MainViewModel_testFromCore(JNIEnv *env, jobject thiz, jint num1,
                                                         jint num2) {
//    jclass  thisClass = env->GetObjectClass(thiz);

//    jmethodID methodId = env->GetMethodID(thisClass, "testFromCore", "(II)Ljava/lang/String;");

    double test = (num1 + num2);
    return test;
}