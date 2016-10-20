/**
 * Created by TangBin on 9/19/16.
 */

import java.util.*;
import java.util.zip.CRC32;

public abstract class Test<C> {
    String name;

    public Test(String name) {
        this.name = name;
    }
    abstract int test(C container, TestParam tp);

}