package com.algorithm.lang.error;

/**
 * Throw to matrix on mismach rows quantity, or mismach colume puantity
 */
public class MismachSizeOfMatrixException extends IndexOutOfBoundsException {
    @java.io.Serial
    private static final long serialVersionUID = -7340273798210792345L;
    public MismachSizeOfMatrixException() {
        super();
    }
    public MismachSizeOfMatrixException(String s) {
        super(s);
    }
    public MismachSizeOfMatrixException(int index) {
        super("Mismach matrix range: " + index);
    }
    public MismachSizeOfMatrixException(long index) {
        super("Mismach matrix range: " + index);
    }
}
