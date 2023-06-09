package devandroid.gkp.appgaseta.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class GasEtaDB extends SQLiteOpenHelper {


    public static final String DB_NAME = "gaseta.db";
    public static final int DB_VERSION = 1;

    Cursor cursor;
    SQLiteDatabase db;

    public GasEtaDB(Context context) {
        super(context, DB_NAME, null, DB_VERSION);

        db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //QUERY SQL para criar uma tabela de dados

        String sqlTabelaCombustivel
                = "CREATE TABLE Combustivel (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nomeDoCombustivel TEXT, " +
                "precoDoCombustivel REAL, " +
                "recomendacao TEXT)";

        db.execSQL(sqlTabelaCombustivel);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    // Create database nome_do_banco_de_dados.db (SQL)
    // 1 - Nome do DB
    // 2 - Versão do DB
    // 3 -

    // Criar métodos para implementar um CRUD
    // C = Create crair o banco de dados e as tabelas

    // Create table (SQL)

    // R = Retrieve recuperar os dados salvos nas tabelas
    // Select * from table (SQL)

    // U = Update alterar os dados e que já existem em um registro na tabela
    // Update from table (SQL)

    // D = Delete deletar os dados/registros de uma tabela
    // Delete from (SQL)
}

