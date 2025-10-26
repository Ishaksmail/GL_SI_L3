
# English Version

### Project Structure (Simplified)

```
GL
├─ src/main/java
│  ├─ GL/               # General configurations (color constants, etc.)
│  │  └─ GL.java
│  ├─ TP1/
│  │  ├─ EX1/ EX2/ ...  # Each exercise in its own folder
│  │  │  ├─ base/       # Core classes for the exercise (models / logic)
│  │  │  ├─ Exec.java   # Exercise execution (demo + explanation)
│  │  │  └─ Tester.java # Main entry point
│  │  ├─ Exec.java      # (Optional) TP-level executor
│  │  └─ Tester.java
│  └─ UTILS/            # Utility classes shared across the project
│     ├─ EX.java
│     ├─ EXEC.java
│     ├─ TP.java
│     ├─ AuthorInfo.java
│     └─ ObjectiveAction.java
├─ TPs/                 # PDF files for theory assignments
├─ LICENSE
└─ pom.xml              # Maven configuration
```

### Main File Purposes (Concise Overview)

* **`base/` in each EXn**
  Contains the core logic and model classes for the exercise (e.g., `Animal`, `Bird`, `Mammal`). These represent the OOP concept being practiced.

* **`Exec.java` (in each EXn)**
  Demonstrates the exercise by creating objects, calling methods, and printing outputs — a practical example of the topic.

* **`Tester.java` (in each EXn)**
  Main entry point to run the exercise. Example:

  ```java
  package TP1;

  import UTILS.AuthorInfo;

  public class Tester {
      public static void main(String[] args) {
          new AuthorInfo();
          Exec exec = new Exec();
          exec.run();
      }
  }
  ```

* **`UTILS/EX.java`**
  Represents a single exercise with an ID, title, and runnable action. Helps organize and execute exercises programmatically.

* **Other `UTILS` files**
  Contain shared helpers, interfaces, and author info.

  * `TP.java`: groups multiple exercises.
  * `EXEC.java`: defines a unified execution interface.
  * `AuthorInfo.java`: displays author metadata.

---


### How to Run an Exercise

* **From IDE (VS Code / IntelliJ)**

  1. Open the project as a Maven project.
  2. Navigate to `.../TP1/EX5/Tester.java` (or any EXn).
  3. Run the `main` method.

* **From Terminal**
  Example to run EX5:

  ```bash
  mvn -q -Dexec.mainClass="TP1.EX5.Tester" compile exec:java
  ```

  *(Ensure the package path is correct.)*

---

### Organizational Tips

* Keep logical implementation inside `base/`.
  Use `Exec.java` only for demonstrations and output.
* Use `EX.java` and `TP.java` to automatically organize exercises.
* Keep `AuthorInfo.java` to display author details upon execution.

---

### Summary

* The structure is modular — each exercise is self-contained.
* `UTILS` provides a common framework for organization and execution.
* To run: open the desired `Tester.java` or use the provided Maven command.

---


# النسخة العربية
### بنية المشروع (مبسطة)

```
GL
├─ src/main/java
│  ├─ GL/               # إعدادات عامة (ثوابت ألوان... الخ)
│  │  └─ GL.java
│  ├─ TP1/
│  │  ├─ EX1/ EX2/ ...  # كل تمرين في مجلد منفصل
│  │  │  ├─ base/       # الفئات الأساسية للتمرين (models / classes)
│  │  │  ├─ Exec.java   # تنفيذ التمرين (عرض + أمثلة)
│  │  │  └─ Tester.java # نقطة التشغيل (main) للتمرين
│  │  ├─ Exec.java      # (اختياري) تجميع/مساعدة على مستوى TP1
│  │  └─ Tester.java
│  └─ UTILS/            # أدوات ومُعرّفات تُستخدم عبر المشروع
│     ├─ EX.java
│     ├─ EXEC.java
│     ├─ TP.java
│     ├─ AuthorInfo.java
│     └─ ObjectiveAction.java
├─ TPs/                 # ملفات PDF للتمارين النظرية
├─ LICENSE
└─ pom.xml              # إعداد Maven
```

---

### وظيفة الملفات الأساسية (مختصر ومركّز)

* **`base/` داخل كل EXn**
  يحتوي على الكلاسات التي تمثل منطق التمرين (مثل `Animal`, `Bird`, `Mammal`...). تمثل هذه الملفات الجانب النظري والتطبيقي للبرمجة الكائنية.

* **`Exec.java` (في كل EXn)**
  يحتوي على الكود التنفيذي الذي يوضح فكرة التمرين عمليًا (إنشاء كائنات، استدعاء الدوال، عرض النتائج).

* **`Tester.java` (في كل EXn)**
  نقطة التشغيل الرئيسية لتجربة الكود. مثال قياسي:

  ```java
  package TP1;

  import UTILS.AuthorInfo;

  public class Tester {
      public static void main(String[] args) {
          new AuthorInfo();
          Exec exec = new Exec();
          exec.run();
      }
  }
  ```

* **`UTILS/EX.java`**
  فئة مساعدة تمثل تمرينًا واحدًا (رقم، عنوان، وإجراء `Runnable`)، تُستخدم لتنظيم وتشغيل التمارين.

* **باقي ملفات `UTILS`**
  تشمل أدوات التنسيق، تعريف الواجهات، وعرض معلومات المؤلف.
  مثلًا:

  * `TP.java` لإدارة مجموعة تمارين.
  * `EXEC.java` لفرض واجهة تنفيذ موحّدة.
  * `AuthorInfo.java` لطباعة بيانات المؤلف.

---


### كيف تشغّل تمرينًا بسرعة

* **من داخل IDE (VS Code / IntelliJ)**

  1. افتح المشروع كمشروع Maven.
  2. انتقل إلى الملف `.../TP1/EX5/Tester.java` (أو أي تمرين آخر).
  3. اضغط **Run** على `main`.

* **من الطرفية (Terminal)**
  لتشغيل تمرين محدد (مثلاً EX5):

  ```bash
  mvn -q -Dexec.mainClass="TP1.EX5.Tester" compile exec:java
  ```

  *(تأكد من مطابقة أسماء الحزم.)*

---

### نصائح تنظيمية

* احصر منطق الكود داخل `base/` فقط.
  الطباعة والعروض التوضيحية ضعها في `Exec.java`.
* استخدم `EX.java` و`TP.java` لتوليد قائمة التمارين تلقائيًا.
* احتفظ بـ `AuthorInfo.java` لعرض معلومات المطوّر عند التشغيل.

---

### خاتمة موجزة

* كل تمرين مستقل بذاته في مجلد فرعي منظم.
* `UTILS` يوفر أساسًا مرنًا لإدارة التمارين.
* للتشغيل: افتح `Tester.java` أو استخدم أمر Maven أعلاه.

---
