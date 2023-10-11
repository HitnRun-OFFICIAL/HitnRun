# HitnRun

## Run the program

### **on Linux**
#### to prepare the database run
```bash
$ ./mvnw -q exec:java -Dexec.mainClass="com.HitnRun.utils.PrepareDatabase"
```
#### to run the program
```bash
$ ./mvnw -q compile exec:java -Dexec.mainClass="com.HitnRun.HitnRun"
```

### **on Windows**
#### to prepare the database run
```cmd
> mvnw.cmd -q exec:java -Dexec.mainClass="com.HitnRun.utils.PrepareDatabase"
```
#### to run the program
```cmd
> mvnw.cmd -q compile exec:java -Dexec.mainClass="com.HitnRun.HitnRun"
```

---

## Unit tests

### **on Linux**
```bash
$ ./mvnw test-compile exec:java -Dexec.mainClass="com.HitnRun.utils.PrepareTestDatabase" -Dexec.classpathScope=test
$ ./mvnw clean test
```

### **on Windows**
```cmd
> mvnw.cmd test-compile exec:java -Dexec.mainClass="com.HitnRun.utils.PrepareTestDatabase" -Dexec.classpathScope=test
> mvnw.cmd clean test
```