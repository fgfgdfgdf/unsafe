#     

### 工具方法

public native long staticFieldOffset(Field var1) 
获取静态字段偏移量
public native long objectFieldOffset(Field var1) 获取非静态字段偏移量

public native int arrayBaseOffset(Class<?> var1) 获取数组元素偏移量

public native int arrayIndexScale(Class<?> var1) 获取数组每个元素大小

public native boolean shouldBeInitialized(Class<?> var1) 判断类是否初始化
public native void ensureClassInitialized(Class<?> var1) 确保类初始化
public native int addressSize(); 获取指针大小
public native int pageSize() 获取内存分页大小
public native void throwException(Throwable var1) 抛出异常
public native Object staticFieldBase(Field var1) 
 获取静态字段所属对象地址

public native int getLoadAverage(double[] var1, int var2)
 获取静态字段所属对象地址

### 内存

#### 获取/修改对象数据(1)

* var1=被修改/查看的对象(静态字段为class对象)
* var2=需要修改字段的偏移量(staticFieldOffset和objectFieldOffset获取)
* var4=设置的新值

源码:
```
    public native int getInt(Object var1, long var2);
    public native void putInt(Object var1, long var2, int var4);

    public native Object getObject(Object var1, long var2);
    public native void putObject(Object var1, long var2, Object var4);

    public native boolean getBoolean(Object var1, long var2);
    public native void putBoolean(Object var1, long var2, boolean var4);

    public native byte getByte(Object var1, long var2);
    public native void putByte(Object var1, long var2, byte var4);

    public native short getShort(Object var1, long var2);
    public native void putShort(Object var1, long var2, short var4);

    public native char getChar(Object var1, long var2);
    public native void putChar(Object var1, long var2, char var4);

    public native long getLong(Object var1, long var2);
    public native void putLong(Object var1, long var2, long var4);

    public native float getFloat(Object var1, long var2);
    public native void putFloat(Object var1, long var2, float var4);

    public native double getDouble(Object var1, long var2);
    public native void putDouble(Object var1, long var2, double var4);
```  

#### 分配/修改内存数据(2)

* var1=内存地址
* var3=分配内容

源码:

```
    public native byte getByte(long var1);
    public native void putByte(long var1, byte var3);

    public native short getShort(long var1);
    public native void putShort(long var1, short var3);

    public native char getChar(long var1);
    public native void putChar(long var1, char var3);

    public native int getInt(long var1);
    public native void putInt(long var1, int var3);

    public native long getLong(long var1);
    public native void putLong(long var1, long var3);

    public native float getFloat(long var1);
    public native void putFloat(long var1, float var3);

    public native double getDouble(long var1);
    public native void putDouble(long var1, double var3);

    public native long getAddress(long var1);
    public native void putAddress(long var1, long var3);
```  

#### 分配/修改内存数据(3)

* `public native long allocateMemory(long var1);` 分配var1大小的内存
* `public native long reallocateMemory(long var1, long var3);`重新分配一段var3大小的内存,var1的内容会被复制
* `public native void setMemory(Object var1, long var2, long var4, byte var6);`
  1: var1!=null,var2=字段偏移量,var4=长度,var6=设置的值
  2：var1=null,var2=内存地址,var4=长度,var6=设置的值
* `public native void copyMemory(Object var1, long var2, Object var4, long var5, long var7);`
  var1/var4 = null/ !null = var2/var5 = 内存地址/ 字段偏移量  
  var7=复制长度
* `public native void freeMemory(long var1);`var1= 内存地址

### CAS

* `public final native boolean compareAndSwapObject(Object var1, long var2, Object var4, Object var5);`
* `public final native boolean compareAndSwapInt(Object var1, long var2, int var4, int var5);`
* `public final native boolean compareAndSwapLong(Object var1, long var2, long var4, long var6);`

### 线程

* `public native void unpark(Object var1);
* `public native void park(boolean var1, long var2);

### Volatile

源码:  
```
    public native Object getObjectVolatile(Object var1, long var2);
    public native void putObjectVolatile(Object var1, long var2, Object var4);

    public native int getIntVolatile(Object var1, long var2);
    public native void putIntVolatile(Object var1, long var2, int var4);

    public native boolean getBooleanVolatile(Object var1, long var2);
    public native void putBooleanVolatile(Object var1, long var2, boolean var4);

    public native byte getByteVolatile(Object var1, long var2);
    public native void putByteVolatile(Object var1, long var2, byte var4);

    public native short getShortVolatile(Object var1, long var2);
    public native void putShortVolatile(Object var1, long var2, short var4);

    public native char getCharVolatile(Object var1, long var2);
    public native void putCharVolatile(Object var1, long var2, char var4);

    public native long getLongVolatile(Object var1, long var2);
    public native void putLongVolatile(Object var1, long var2, long var4);

    public native float getFloatVolatile(Object var1, long var2);
    public native void putFloatVolatile(Object var1, long var2, float var4);

    public native double getDoubleVolatile(Object var1, long var2);
    public native void putDoubleVolatile(Object var1, long var2, double var4);

    public native void putOrderedObject(Object var1, long var2, Object var4);
    
    public native void putOrderedInt(Object var1, long var2, int var4);

    public native void putOrderedLong(Object var1, long var2, long var4);
```

### 内存屏障

源码:  
```
    public native void loadFence();
    public native void storeFence();
    public native void fullFence();
```

### class

源码:
```
    public native Class<?> defineClass(String var1, byte[] var2, int var3, int var4, ClassLoader var5, ProtectionDomain var6);
    public native Class<?> defineAnonymousClass(Class<?> var1, byte[] var2, Object[] var3);
    public native Object allocateInstance(Class<?> var1) throws InstantiationException;
```

### 锁

源码:  

```
    public native void monitorEnter(Object var1);
    public native void monitorExit(Object var1);
    public native boolean tryMonitorEnter(Object var1);
```
