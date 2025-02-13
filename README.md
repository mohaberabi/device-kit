## DeviceKit KMP

**DeviceKit KMP** is a Kotlin Multiplatform library that provides a comprehensive set of device
information, including CPU, GPU, RAM, storage, battery, and system details for both **Android** and
**iOS** platforms.

### Features

✔ Retrieve detailed CPU, GPU, RAM, Storage, and Battery information  
✔ Supports **Android** and **iOS** using Kotlin Multiplatform  
✔ Easy to integrate

## Installation

Add the following dependency to your **Kotlin Multiplatform** project:

```kotlin
commonMain.dependencies {
    implementation("io.mohaberabi:device-kit:0.0.6")
}
```

## Usage

### Common Code

```kotlin
import com.yourpackage.devicekit.*

fun provideDeviceKit(factory: DeviceKitFactory) = factory.create()
```

### Android Usage

```kotlin
val deviceKit = AndroidDeviceKitFactory(context).create()
println("CPU Info: ${deviceKit.cpu.cpuInfo}")
println("Battery Level: ${deviceKit.battery.batteryLevel}%")
println("Total RAM: ${deviceKit.ram.totalRam} MB")
```

### iOS Usage

```kotlin
val deviceKit = IosDeviceKitFactory().create()
println("Device Name: ${deviceKit.info.deviceName}")
println("OS Version: ${deviceKit.info.osVersion}")
println("Screen Size: ${deviceKit.gpu.screenSize}")
```

## API Overview

### **DeviceKit Interface**

```kotlin
interface DeviceKit {
    val ram: RAMKit
    val cellular: CellKit
    val gpu: GPUKit
    val cpu: CPUKit
    val info: InfoKit
    val storage: StorageKit
    val battery: BatteryKit
}
```

### **Battery Information**

```kotlin
interface BatteryKit {
    val deviceThermal: String
    val batteryLevel: Int
    val batteryTemperature: Double
    val batteryPower: BatteryPower
}
```

### **CPU Information**

```kotlin
interface CPUKit {
    val cpuInfo: String
    val cpuCores: Int
}
```

### **GPU Information**

```kotlin
interface GPUKit {
    val gpuInfo: String
    val resolution: String
    val screenDensity: Float
    val refreshRate: Float
    val screenSize: String
}
```

### **RAM Information**

```kotlin
interface RAMKit {
    val ramInfo: String
    val availableRam: Long
    val totalRam: Long
}
```

### **Storage Information**

```kotlin
interface StorageKit {
    val storageInfo: String
    val availableExternalStorageSize: Long?
    val totalInternalStorageSize: Long
    val availableInternalStorageSize: Long
    val externalStorageAvailable: Boolean
}
```

### **Device Information**

```kotlin
interface InfoKit {
    val deviceName: String
    val manufacturer: String
    val osName: String
    val osVersionName: String
    val osVersion: String
    val appSize: Double
    val model: String
    val deviceTimeZone: String
    val uuid: String
}
```


