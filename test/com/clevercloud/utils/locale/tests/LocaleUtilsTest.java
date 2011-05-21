/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clevercloud.utils.locale.tests;

import java.util.List;
import java.util.ArrayList;
import java.util.Locale;
import com.clevercloud.utils.locale.LocaleSet;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author waxzce
 */
public class LocaleUtilsTest {

   
    @Test
    public void simpleGoToDefault() {
        LocaleSet ls = new LocaleSet();

        ls.add(Locale.UK);
        ls.add(Locale.FRANCE);
        ls.add(Locale.CHINA);

        List<Locale> ll = new ArrayList<Locale>();
        ll.add(Locale.ITALIAN);
        System.out.println("note the default locale is : "+Locale.getDefault());
        assertEquals(Locale.getDefault(), ls.getTheBestLocale(ll));

    }
    
    @Test
    public void theSameIsFirst() {
        LocaleSet ls = new LocaleSet();

        ls.add(Locale.UK);
        ls.add(Locale.FRANCE);
        ls.add(Locale.CHINA);

        List<Locale> ll = new ArrayList<Locale>();
        ll.add(Locale.CHINA);

        assertEquals(Locale.CHINA, ls.getTheBestLocale(ll));

    }
    
    @Test
    public void theSameIsSecond() {
        LocaleSet ls = new LocaleSet();

        ls.add(Locale.UK);
        ls.add(Locale.FRANCE);
        ls.add(Locale.CHINA);

        List<Locale> ll = new ArrayList<Locale>();
        ll.add(Locale.ITALIAN);
        ll.add(Locale.UK);

        assertEquals(Locale.UK, ls.getTheBestLocale(ll));

    }
    
    @Test
    public void theSameLangUSandUK() {
        LocaleSet ls = new LocaleSet();

        ls.add(Locale.UK);
        ls.add(Locale.FRANCE);
        ls.add(Locale.CHINA);

        List<Locale> ll = new ArrayList<Locale>();
        ll.add(Locale.US);

        assertEquals(Locale.UK, ls.getTheBestLocale(ll));

    }
    
    @Test
    public void USbecomeOnlyEN() {
        LocaleSet ls = new LocaleSet();

        ls.add(Locale.UK);
        ls.add(Locale.FRANCE);
        ls.add(Locale.CHINA);
        ls.add(new Locale("EN"));

        List<Locale> ll = new ArrayList<Locale>();
        ll.add(Locale.US);

        assertEquals(new Locale("EN"), ls.getTheBestLocale(ll));

    }
    
    @Test
    public void TestWithVariant() {
        LocaleSet ls = new LocaleSet();

        ls.add(Locale.UK);
        ls.add(Locale.FRANCE);
        ls.add(Locale.CHINA);
        ls.add(new Locale("EN", "US", "paca"));

        List<Locale> ll = new ArrayList<Locale>();
        ll.add(new Locale("EN", "US", "paca"));

        assertEquals(new Locale("EN", "US", "paca"), ls.getTheBestLocale(ll));

    }
    
     @Test
    public void ChangeDefault() {
        LocaleSet ls = new LocaleSet();

        ls.add(Locale.UK);
        ls.add(Locale.FRANCE);
        ls.add(Locale.CHINA);

        List<Locale> ll = new ArrayList<Locale>();
        ll.add(Locale.ITALIAN);
        
        ls.setSpecificLocaleDefault(Locale.GERMANY);

        assertEquals(Locale.GERMANY, ls.getTheBestLocale(ll));

    }
}
