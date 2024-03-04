package util.Interface;

import java.lang.reflect.Array;

public interface Expander<T> {
    default T[] dynamicDilatation(T[] src, int newLen){
        if(src.length>=newLen){
            return src;
        }

        T[] res = (T[]) Array.newInstance(src.getClass().getComponentType(),newLen);

        System.arraycopy(src,0,res,0,src.length);

        return res;
    }
}
