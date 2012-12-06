package jnr.ffi.provider.jffi;

import jnr.ffi.NativeType;

import java.lang.annotation.Annotation;
import java.util.Collection;

import static jnr.ffi.provider.jffi.NumberUtil.sizeof;

/**
 *
 */
abstract class SigType {
    private final Class javaType, convertedType;
    private final Collection<Annotation> annotations;
    final NativeType nativeType;

    SigType(Class javaType, NativeType nativeType, Collection<Annotation> annotations, Class convertedType) {
        this.javaType = javaType;
        this.annotations = annotations;
        this.convertedType = convertedType;
        this.nativeType = nativeType;
    }

    final Class getDeclaredType() {
        return javaType;
    }

    final Class effectiveJavaType() {
        return convertedType;
    }

    final int size() {
        return sizeof(nativeType);
    }

    final Collection<Annotation> annotations() {
        return annotations;
    }

    public final String toString() {
        return String.format("declared: %s, effective: %s, native: %s", getDeclaredType(), effectiveJavaType(), nativeType);
    }
}