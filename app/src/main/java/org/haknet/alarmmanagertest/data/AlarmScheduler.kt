package org.haknet.alarmmanagertest.data

interface AlarmScheduler {
    fun schedule(item: AlarmItem)
    fun cancel(item: AlarmItem)
}