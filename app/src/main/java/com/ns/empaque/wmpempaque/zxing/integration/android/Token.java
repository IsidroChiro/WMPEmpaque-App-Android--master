package com.ns.empaque.wmpempaque.zxing.integration.android;

abstract class Token {

    static final Token EMPTY = new SimpleToken(null, 0, 0);

    private final Token previous;

    Token(Token previous) {
        this.previous = previous;
    }

    final Token getPrevious() {
        return previous;
    }

    final Token add(int value, int bitCount) {
        return new SimpleToken(this, value, bitCount);
    }

    final Token addBinaryShift(int start, int byteCount) {
        //int bitCount = (byteCount * 8) + (byteCount <= 31 ? 10 : byteCount <= 62 ? 20 : 21);
        return new BinaryShiftToken(this, start, byteCount);
    }

    abstract void appendTo(BitArray bitArray, byte[] text);

}
