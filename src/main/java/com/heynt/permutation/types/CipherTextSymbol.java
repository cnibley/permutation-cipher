package com.heynt.permutation.types;

/**
 * Represents a single ciphertext symbol
 * Range is always 0 to 102
 * 
 * @author cnibley
 *
 */
public class CipherTextSymbol
{
    private short value;
    private final short MAX_VALUE = 102;
    private final short MIN_VALUE = 0;

    public short getValue()
    {
        return value;
    }

    public void setValue(short value)
    {
        this.value = value;
    }
}
