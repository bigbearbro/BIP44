/*
 *  BIP44
 *  Copyright (C) 2017 Alan Evans, NovaCrypto
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <https://www.gnu.org/licenses/>.
 *
 *  Original source: https://github.com/NovaCrypto/BIP44
 *  You can contact the authors via github issues.
 */

package io.github.novacrypto;

import io.github.novacrypto.bip44.CoinType;
import org.junit.Test;

import static io.github.novacrypto.bip44.Purpose.purpose;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public final class CoinTypeTests {

    @Test
    public void coinType0_Bitcoin() {
        assertEquals("m/44'/0'", purpose(44).coinType(0).toString());
    }

    @Test
    public void coinType1_BitcoinTestNet() {
        assertEquals("m/44'/1'", purpose(44).coinType(1).toString());
    }

    @Test
    public void prupose49_coinType1_Bitcoin() {
        assertEquals("m/49'/1'", purpose(49).coinType(1).toString());
    }

    @Test
    public void coinTypeStringIsPreCalculated() {
        final CoinType coinType = purpose(44).coinType(0);
        assertSame(coinType.toString(), coinType.toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void coinType_negative() {
        purpose(44).coinType(-1);
    }
}