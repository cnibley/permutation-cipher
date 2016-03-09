package com.heynt.permutation.types;

import com.google.common.collect.ArrayTable;

/**
 * This class implements a thread safe two dimensional table for keeping an up-to-date reference
 * of which characters can possibly match to cipher text symbols
 * 
 * 
 * @see http://google.github.io/guava/releases/snapshot/api/docs/com/google/common/collect/ArrayTable.html
 * 
 * @author cnibley
 *
 */
public class EliminationTable
{
    //ArrayTable<R,C,V>
    // 103 rows of CipherTextSymbol. Range: [0-102]
    // Characters as plaintext. Range: [a-z]
    // Bitflags are the values
    public volatile ArrayTable<CipherTextSymbol, Character, Boolean> table;

    // TODO The table starts with true values in all the slots
    // TODO Implement
}
