/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clevercloud.utils.locale;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author waxzce
 */
public class LocaleSet extends HashSet<Locale> implements Set<Locale> {

    
    private Locale specificLocaleDefault = Locale.getDefault();

    public Locale getSpecificLocaleDefault() {
        return specificLocaleDefault;
    }

    public void setSpecificLocaleDefault(Locale specificLocaleDefault) {
        this.specificLocaleDefault = specificLocaleDefault;
    }

    
    
    public Locale getTheBestLocale(List<Locale> locales) {
        for (Locale l : locales) {
            if (this.contains(l)) {
                return l;
            }

            if (l.getVariant() != "") {
                Locale withOutAlter = new Locale(l.getLanguage(), l.getCountry());
                if (this.contains(withOutAlter)) {
                    return withOutAlter;
                }
            }

            Locale onlyLang = new Locale(l.getLanguage());
            if (this.contains(onlyLang)) {
                return onlyLang;
            }
            for (Locale ll : this) {
                Locale localeOnlyLang = new Locale(ll.getLanguage());
                if (onlyLang.equals(localeOnlyLang)) {
                    return ll;
                }
            }



        }
        return specificLocaleDefault;

    }
}
