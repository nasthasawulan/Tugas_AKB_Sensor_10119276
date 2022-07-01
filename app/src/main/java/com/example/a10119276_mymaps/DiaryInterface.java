package com.example.a10119276_mymaps;

import android.database.Cursor;

import com.example.a10119276_mymaps.model.Diary;

/**
 *  NIM   : 10119276
 *  Nama  : Nasthasa Wulan Ghani Sopian
 *  Kelas : IF-7
 */

public interface DiaryInterface {

    public Cursor read();
    public boolean create(Diary diary);
    public boolean update(Diary diary);
    public boolean delete(String id);
}
