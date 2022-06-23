package com.example.mychat;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class ContactsDao_Impl implements ContactsDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Contact> __insertionAdapterOfContact;

  private final EntityDeletionOrUpdateAdapter<Contact> __deletionAdapterOfContact;

  private final EntityDeletionOrUpdateAdapter<Contact> __updateAdapterOfContact;

  public ContactsDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfContact = new EntityInsertionAdapter<Contact>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Contact` (`id`,`name`,`server`,`last`,`lastdate`) VALUES (?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Contact value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getId());
        }
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        if (value.getServer() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getServer());
        }
        if (value.getLast() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getLast());
        }
        if (value.getLastdate() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getLastdate());
        }
      }
    };
    this.__deletionAdapterOfContact = new EntityDeletionOrUpdateAdapter<Contact>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `Contact` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Contact value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getId());
        }
      }
    };
    this.__updateAdapterOfContact = new EntityDeletionOrUpdateAdapter<Contact>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Contact` SET `id` = ?,`name` = ?,`server` = ?,`last` = ?,`lastdate` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Contact value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getId());
        }
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        if (value.getServer() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getServer());
        }
        if (value.getLast() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getLast());
        }
        if (value.getLastdate() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getLastdate());
        }
        if (value.getId() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getId());
        }
      }
    };
  }

  @Override
  public void insert(final Contact... contacts) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfContact.insert(contacts);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final Contact... contacts) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfContact.handleMultiple(contacts);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final Contact... contacts) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfContact.handleMultiple(contacts);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<Contact> index() {
    final String _sql = "SELECT * FROM Contact";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfServer = CursorUtil.getColumnIndexOrThrow(_cursor, "server");
      final int _cursorIndexOfLast = CursorUtil.getColumnIndexOrThrow(_cursor, "last");
      final int _cursorIndexOfLastdate = CursorUtil.getColumnIndexOrThrow(_cursor, "lastdate");
      final List<Contact> _result = new ArrayList<Contact>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Contact _item;
        _item = new Contact();
        final String _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getString(_cursorIndexOfId);
        }
        _item.setId(_tmpId);
        final String _tmpName;
        if (_cursor.isNull(_cursorIndexOfName)) {
          _tmpName = null;
        } else {
          _tmpName = _cursor.getString(_cursorIndexOfName);
        }
        _item.setName(_tmpName);
        final String _tmpServer;
        if (_cursor.isNull(_cursorIndexOfServer)) {
          _tmpServer = null;
        } else {
          _tmpServer = _cursor.getString(_cursorIndexOfServer);
        }
        _item.setServer(_tmpServer);
        final String _tmpLast;
        if (_cursor.isNull(_cursorIndexOfLast)) {
          _tmpLast = null;
        } else {
          _tmpLast = _cursor.getString(_cursorIndexOfLast);
        }
        _item.setLast(_tmpLast);
        final String _tmpLastdate;
        if (_cursor.isNull(_cursorIndexOfLastdate)) {
          _tmpLastdate = null;
        } else {
          _tmpLastdate = _cursor.getString(_cursorIndexOfLastdate);
        }
        _item.setLastdate(_tmpLastdate);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Contact get(final String id) {
    final String _sql = "SELECT * FROM Contact WHERE id=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (id == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, id);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfServer = CursorUtil.getColumnIndexOrThrow(_cursor, "server");
      final int _cursorIndexOfLast = CursorUtil.getColumnIndexOrThrow(_cursor, "last");
      final int _cursorIndexOfLastdate = CursorUtil.getColumnIndexOrThrow(_cursor, "lastdate");
      final Contact _result;
      if(_cursor.moveToFirst()) {
        _result = new Contact();
        final String _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getString(_cursorIndexOfId);
        }
        _result.setId(_tmpId);
        final String _tmpName;
        if (_cursor.isNull(_cursorIndexOfName)) {
          _tmpName = null;
        } else {
          _tmpName = _cursor.getString(_cursorIndexOfName);
        }
        _result.setName(_tmpName);
        final String _tmpServer;
        if (_cursor.isNull(_cursorIndexOfServer)) {
          _tmpServer = null;
        } else {
          _tmpServer = _cursor.getString(_cursorIndexOfServer);
        }
        _result.setServer(_tmpServer);
        final String _tmpLast;
        if (_cursor.isNull(_cursorIndexOfLast)) {
          _tmpLast = null;
        } else {
          _tmpLast = _cursor.getString(_cursorIndexOfLast);
        }
        _result.setLast(_tmpLast);
        final String _tmpLastdate;
        if (_cursor.isNull(_cursorIndexOfLastdate)) {
          _tmpLastdate = null;
        } else {
          _tmpLastdate = _cursor.getString(_cursorIndexOfLastdate);
        }
        _result.setLastdate(_tmpLastdate);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
