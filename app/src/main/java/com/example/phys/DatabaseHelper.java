package com.example.phys;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "physics.db";
    private static final int DATABASE_VERSION = 2;

    public static final String TABLE_FORMULAS = "formulas";
    public static final String TABLE_THEORY = "theory";
    public static final String TABLE_VIDEOS = "videos";

    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_DESCRIPTION = "description";
    public static final String COLUMN_CONTENT = "content";
    public static final String COLUMN_URL = "url";

    private static final String CREATE_TABLE_FORMULAS =
            "CREATE TABLE " + TABLE_FORMULAS + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_NAME + " TEXT, " +
                    COLUMN_DESCRIPTION + " TEXT);";

    private static final String CREATE_TABLE_THEORY =
            "CREATE TABLE " + TABLE_THEORY + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_NAME + " TEXT, " +
                    COLUMN_CONTENT + " TEXT);";

    private static final String CREATE_TABLE_VIDEOS =
            "CREATE TABLE " + TABLE_VIDEOS + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_NAME + " TEXT, " +
                    COLUMN_URL + " TEXT);";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d("DatabaseHelper", "onCreate() called");
        db.execSQL(CREATE_TABLE_FORMULAS);
        db.execSQL(CREATE_TABLE_THEORY);
        db.execSQL(CREATE_TABLE_VIDEOS);
        insertInitialData(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_FORMULAS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_THEORY);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_VIDEOS);
        onCreate(db);
    }

    private void insertInitialData(SQLiteDatabase db) {
        // Вставка начальных данных
        insertTheory(db, "МЕХАНИКА", "Механика – это раздел физики, изучающий законы механического движения.  Основные законы механики открыл великий английский учёный Исаак Ньютон , который жил в XVII веке. \n" +
                "\n" +
                "Механика изучает движение тел в различных агрегатных состояниях: твёрдом, жидком и газообразном. \n" +
                "\n" +
                "Механика делится на три раздела: кинематику, динамику и статику. \n" +
                "\n" +
                "Кинематика – это раздел механики, изучающий движение тел вне связи с причинами, которые вызывают или изменяют это движение.  Кинематика отвечает только на вопрос «Как движется тело?». \n" +
                "\n" +
                "Динамика – это раздел механики, который изучает законы движения тел и причины, вызывающие или изменяющие это движение.  Динамика отвечает на вопрос «Почему тело движется так, а не иначе?». \n" +
                "\n" +
                "Статика – это раздел физики, рассматривающий условия равновесия системы сил, то есть когда тела остаются в покое или движутся с постоянной скоростью. \n" +
                "\n" +
                "Без знания механики невозможно изучение других разделов физики, так как механическое движение (перемещение тел) имеет место при всех физических явлениях. ");
        insertTheory(db, "ИМПУЛЬС ТЕЛА", "Импульсом (количеством движения) тела называют физическую векторную величину, являющуюся количественной характеристикой поступательного движения тел. Импульс обозначается р. Импульс тела равен произведению массы тела на его скорость, т.е. он рассчитывается по формуле:\n" +
                "\n" +
                "P = MV\n" +
                "\n" +
                "Направление вектора импульса совпадает с направлением вектора скорости тела (направлен по касательной к траектории). Единица измерения импульса – кг∙м/с.\n" +
                "\n" +
                "Общий импульс системы тел равен векторной сумме импульсов всех тел системы:\n" +
                "\n" +
                "P = P1 + P2 + P3 + ...\n" +
                "\n" +
                "Изменение импульса одного тела находится по формуле (обратите внимание, что разность конечного и начального импульсов векторная):\n" +
                "\n" +
                "∆P = Pк - Pн\n" +
                "\n" +
                "где: Pн – импульс тела в начальный момент времени, Pк – в конечный. Главное не путать два последних понятия.\n" +
                "\n" +
                "Абсолютно упругий удар – абстрактная модель соударения, при которой не учитываются потери энергии на трение, деформацию, и т.п. Никакие другие взаимодействия, кроме непосредственного контакта, не учитываются. При абсолютно упругом ударе о закрепленную поверхность скорость объекта после удара по модулю равна скорости объекта до удара, то есть величина импульса не меняется. Может поменяться только его направление. При этом угол падения равен углу отражения.\n" +
                "\n" +
                "Абсолютно неупругий удар – удар, в результате которого тела соединяются и продолжают дальнейшее своё движение как единое тело. Например, пластилиновый шарик при падении на любую поверхность полностью прекращает свое движение, при столкновении двух вагонов срабатывает автосцепка и они так же продолжают двигаться дальше вместе.\n" +
                "\n" +
                " ");
        insertTheory(db, "ЗАКОН СОХРАНЕНИЯ ИМПУЛЬСА", "При взаимодействии тел импульс одного тела может частично или полностью передаваться другому телу. Если на систему тел не действуют внешние силы со стороны других тел, такая система называется замкнутой.\n" +
                "\n" +
                "В замкнутой системе векторная сумма импульсов всех тел, входящих в систему, остается постоянной при любых взаимодействиях тел этой системы между собой. Этот фундаментальный закон природы называется законом сохранения импульса (ЗСИ). Следствием его являются законы Ньютона. Второй закон Ньютона в импульсной форме может быть записан следующим образом:\n" +
                "\n" +
                "F = ∆P / ∆T\n" +
                "\n" +
                "Как следует из данной формулы, в случае если на систему тел не действует внешних сил, либо действие внешних сил скомпенсировано (равнодействующая сила равна нолю), то изменение импульса равно нолю, что означает, что общий импульс системы сохраняется:\n" +
                "\n" +
                "Pк - Pн = 0  =>  Pк = Pн\n" +
                "\n" +
                "Аналогично можно рассуждать для равенства нулю проекции силы на выбранную ось. Если внешние силы не действуют только вдоль одной из осей, то сохраняется проекция импульса на данную ось, например:\n" +
                "\n" +
                "Fx = 0  =>  Px = const\n" +
                "\n" +
                "Аналогичные записи можно составить и для остальных координатных осей. Так или иначе, нужно понимать, что при этом сами импульсы могут меняться, но именно их сумма остается постоянной. Закон сохранения импульса во многих случаях позволяет находить скорости взаимодействующих тел даже тогда, когда значения действующих сил неизвестны.");
        insertTheory(db, "ЭНЕРГИЯ", "Энергия – это скалярная физическая величина, характеризующая состояние материи и меру различных форм движения и взаимодействия. Энергия сохраняется и превращается из одной формы в другую. Основные виды энергии:\n" +
                "\n" +
                "1. Кинетическая энергия – энергия движения тела. Рассчитывается по формуле: E_к = (m*v^2)/2.\n" +
                "\n" +
                "2. Потенциальная энергия – энергия положения тела в поле сил. Рассчитывается по формуле: E_п = m*g*h для гравитационного поля.\n" +
                "\n" +
                "3. Внутренняя энергия – сумма кинетической и потенциальной энергии частиц, составляющих тело.\n" +
                "\n" +
                "Закон сохранения энергии гласит, что энергия не возникает из ничего и не исчезает, а только переходит из одной формы в другую. Общая энергия замкнутой системы остается постоянной.");

        insertTheory(db, "РАБОТА", "Работа – это скалярная физическая величина, равная произведению силы, действующей на тело, на перемещение тела в направлении этой силы. Рассчитывается по формуле:\n" +
                "\n" +
                "A = F * s * cos(α),\n" +
                "\n" +
                "где F – сила, s – перемещение, α – угол между направлением силы и направлением перемещения. Единица измерения работы – Джоуль (Дж).");


        insertFormula(db, "Импульс", "P = MV");
        insertFormula(db, "Второй закон Ньютона (в импульсной форме)", "F = ∆P / ∆T");
        insertFormula(db, "Работа", "A = F * s * cos(α)");
        insertFormula(db, "Второй закон Ньютона", "F = ma");
        insertFormula(db, "Ускорение", "a = ∆v / ∆t");
        insertFormula(db, "Сила трения", "F_тр = μN");
        insertFormula(db, "Потенциальная энергия", "E_p = mgh");
        insertFormula(db, "Кинетическая энергия", "E_k = 1/2 mv^2");
        insertFormula(db, "Закон всемирного тяготения", "F = G(m1m2)/r^2");
        insertFormula(db, "Работа", "A = Fd cos(θ)");
        insertFormula(db, "Момент силы", "τ = rF sin(θ)");
        insertFormula(db, "Импульс силы", "J = F∆t");
        insertFormula(db, "Энергия фотона", "E = hf");
        insertFormula(db, "Уравнение движения", "s = ut + 1/2 at^2");
        insertFormula(db, "Период колебаний маятника", "T = 2π√(l/g)");
        insertFormula(db, "Закон Ома для участка цепи", "I = U/R");
        insertFormula(db, "Энергия в электрическом поле", "E = qV");
        insertFormula(db, "Мощность электрического тока", "P = UI");
        insertFormula(db, "Магнитная сила на проводник", "F = BIL sin(θ)");
        insertFormula(db, "Сила Лоренца", "F = qvB sin(θ)");

        insertVideo(db, "Кинематика за 8 мин - Марсель Нуртдинов. Профильная матиматика ЕГЭ", "https://www.youtube.com/watch?v=Ui0bFK4_87M");
        insertVideo(db, "Импульс тела. Закон сохранения импульса - ИНФОУРОК", "https://www.youtube.com/watch?v=cHWJr0PufIg");
        insertVideo(db, "Работа и мощность электрического тока - ИНФОУРОК", "https://www.youtube.com/watch?v=mzaahtoVmZc");
        insertVideo(db, "Сила трения - GetAClass - Физика в опытах и экспериментах", "https://www.youtube.com/watch?v=sT-HUE__vII");
        insertVideo(db, "Уравнение движения - MIK", "https://www.youtube.com/watch?v=2UjOCU6uvAY");
        insertVideo(db, "ФИЗИКА С НУЛЯ — Сила Лоренца, Правило Левой руки - \n" +
                "INTENSIVKURS - Учебный Центр для Школьников ", "https://www.youtube.com/watch?v=rAf2as3Mx38");
    }

    private void insertFormula(SQLiteDatabase db, String name, String description) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, name);
        values.put(COLUMN_DESCRIPTION, description);
        db.insert(TABLE_FORMULAS, null, values);
    }

    private void insertTheory(SQLiteDatabase db, String name, String content) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, name);
        values.put(COLUMN_CONTENT, content);
        db.insert(TABLE_THEORY, null, values);
    }

    private void insertVideo(SQLiteDatabase db, String name, String url) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, name);
        values.put(COLUMN_URL, url);
        db.insert(TABLE_VIDEOS, null, values);
    }

    public List<String> getTheoryData() {
        List<String> theoryList = new ArrayList<>();
        // Select all rows from the theory table
        String selectQuery = "SELECT * FROM " + TABLE_THEORY;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;

        try {
            cursor = db.rawQuery(selectQuery, null);

            // Get the index of the content column
            int contentIndex = cursor.getColumnIndex(COLUMN_CONTENT);
            int nameIndex = cursor.getColumnIndex(COLUMN_NAME);
            // Loop through all rows and add content to the list
            while (cursor.moveToNext()) {
                String content = cursor.getString(contentIndex);
                String name = cursor.getString(nameIndex);
                theoryList.add(name);
                theoryList.add(content);
                Log.d("DatabaseHelper", "Theory data: " + content);
            }
        } catch (Exception e) {
            Log.e("DatabaseHelper", "Error while getting theory data: " + e.getMessage());
        } finally {
            // Close cursor and database connection
            if (cursor != null) {
                cursor.close();
            }
            db.close();
        }

        return theoryList;
    }
    public List<String> getFormulasData() {
        List<String> formulasList = new ArrayList<>();
        // Select all rows from the theory table
        String selectQuery = "SELECT * FROM " + TABLE_FORMULAS;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;

        try {
            cursor = db.rawQuery(selectQuery, null);

            // Get the index of the content column
            int contentIndex = cursor.getColumnIndex(COLUMN_DESCRIPTION);
            int nameIndex = cursor.getColumnIndex(COLUMN_NAME);
            // Loop through all rows and add content to the list
            while (cursor.moveToNext()) {
                String content = cursor.getString(contentIndex);
                String name = cursor.getString(nameIndex);
                formulasList.add(name);
                formulasList.add(content);
                Log.d("DatabaseHelper", "Formulas data: " + content);
            }
        } catch (Exception e) {
            Log.e("DatabaseHelper", "Error while getting formulas data: " + e.getMessage());
        } finally {
            // Close cursor and database connection
            if (cursor != null) {
                cursor.close();
            }
            db.close();
        }

        return formulasList;
    }
    public List<String> getVideosData() {
        List<String> videosList = new ArrayList<>();
        // Select all rows from the theory table
        String selectQuery = "SELECT * FROM " + TABLE_VIDEOS;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;

        try {
            cursor = db.rawQuery(selectQuery, null);

            // Get the index of the content column
            int contentIndex = cursor.getColumnIndex(COLUMN_URL);
            int nameIndex = cursor.getColumnIndex(COLUMN_NAME);
            // Loop through all rows and add content to the list
            while (cursor.moveToNext()) {
                String content = cursor.getString(contentIndex);
                String name = cursor.getString(nameIndex);
                videosList.add(name);
                videosList.add(content);
                Log.d("DatabaseHelper", "Videos data: " + content);
            }
        } catch (Exception e) {
            Log.e("DatabaseHelper", "Error while getting videos data: " + e.getMessage());
        } finally {
            // Close cursor and database connection
            if (cursor != null) {
                cursor.close();
            }
            db.close();
        }

        return videosList;
    }
}
