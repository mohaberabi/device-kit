package com.mohaberabi.devicekit.data

import com.mohaberabi.devicekit.domain.BatteryKit
import com.mohaberabi.devicekit.domain.CPUKit
import com.mohaberabi.devicekit.domain.CellKit
import com.mohaberabi.devicekit.domain.DeviceKit
import com.mohaberabi.devicekit.domain.GPUKit
import com.mohaberabi.devicekit.domain.InfoKit
import com.mohaberabi.devicekit.domain.RAMKit
import com.mohaberabi.devicekit.domain.StorageKit

internal class IosDeviceKit : DeviceKit {
    override val ram: RAMKit = IosRamKit()
    override val cellular: CellKit = IosCellKit()
    override val gpu: GPUKit = IosGpuKit()
    override val cpu: CPUKit = IosCpuKit()
    override val info: InfoKit = IosInfoKit()
    override val storage: StorageKit = IosStorageKit()
    override val battery: BatteryKit = IosBatteryKit()
}


