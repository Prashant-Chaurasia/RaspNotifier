/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.12
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.chilkatsoft;

public class CkTaskChain {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected CkTaskChain(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(CkTaskChain obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        chilkatJNI.delete_CkTaskChain(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public CkTaskChain() {
    this(chilkatJNI.new_CkTaskChain(), true);
  }

  public void LastErrorXml(CkString str) {
    chilkatJNI.CkTaskChain_LastErrorXml(swigCPtr, this, CkString.getCPtr(str), str);
  }

  public void LastErrorHtml(CkString str) {
    chilkatJNI.CkTaskChain_LastErrorHtml(swigCPtr, this, CkString.getCPtr(str), str);
  }

  public void LastErrorText(CkString str) {
    chilkatJNI.CkTaskChain_LastErrorText(swigCPtr, this, CkString.getCPtr(str), str);
  }

  public void get_DebugLogFilePath(CkString str) {
    chilkatJNI.CkTaskChain_get_DebugLogFilePath(swigCPtr, this, CkString.getCPtr(str), str);
  }

  public String debugLogFilePath() {
    return chilkatJNI.CkTaskChain_debugLogFilePath(swigCPtr, this);
  }

  public void put_DebugLogFilePath(String newVal) {
    chilkatJNI.CkTaskChain_put_DebugLogFilePath(swigCPtr, this, newVal);
  }

  public boolean get_Finished() {
    return chilkatJNI.CkTaskChain_get_Finished(swigCPtr, this);
  }

  public int get_HeartbeatMs() {
    return chilkatJNI.CkTaskChain_get_HeartbeatMs(swigCPtr, this);
  }

  public void put_HeartbeatMs(int newVal) {
    chilkatJNI.CkTaskChain_put_HeartbeatMs(swigCPtr, this, newVal);
  }

  public boolean get_Inert() {
    return chilkatJNI.CkTaskChain_get_Inert(swigCPtr, this);
  }

  public void get_LastErrorHtml(CkString str) {
    chilkatJNI.CkTaskChain_get_LastErrorHtml(swigCPtr, this, CkString.getCPtr(str), str);
  }

  public String lastErrorHtml() {
    return chilkatJNI.CkTaskChain_lastErrorHtml(swigCPtr, this);
  }

  public void get_LastErrorText(CkString str) {
    chilkatJNI.CkTaskChain_get_LastErrorText(swigCPtr, this, CkString.getCPtr(str), str);
  }

  public String lastErrorText() {
    return chilkatJNI.CkTaskChain_lastErrorText(swigCPtr, this);
  }

  public void get_LastErrorXml(CkString str) {
    chilkatJNI.CkTaskChain_get_LastErrorXml(swigCPtr, this, CkString.getCPtr(str), str);
  }

  public String lastErrorXml() {
    return chilkatJNI.CkTaskChain_lastErrorXml(swigCPtr, this);
  }

  public boolean get_LastMethodSuccess() {
    return chilkatJNI.CkTaskChain_get_LastMethodSuccess(swigCPtr, this);
  }

  public void put_LastMethodSuccess(boolean newVal) {
    chilkatJNI.CkTaskChain_put_LastMethodSuccess(swigCPtr, this, newVal);
  }

  public boolean get_Live() {
    return chilkatJNI.CkTaskChain_get_Live(swigCPtr, this);
  }

  public int get_NumTasks() {
    return chilkatJNI.CkTaskChain_get_NumTasks(swigCPtr, this);
  }

  public void get_Status(CkString str) {
    chilkatJNI.CkTaskChain_get_Status(swigCPtr, this, CkString.getCPtr(str), str);
  }

  public String status() {
    return chilkatJNI.CkTaskChain_status(swigCPtr, this);
  }

  public int get_StatusInt() {
    return chilkatJNI.CkTaskChain_get_StatusInt(swigCPtr, this);
  }

  public boolean get_StopOnFailedTask() {
    return chilkatJNI.CkTaskChain_get_StopOnFailedTask(swigCPtr, this);
  }

  public void put_StopOnFailedTask(boolean newVal) {
    chilkatJNI.CkTaskChain_put_StopOnFailedTask(swigCPtr, this, newVal);
  }

  public boolean get_VerboseLogging() {
    return chilkatJNI.CkTaskChain_get_VerboseLogging(swigCPtr, this);
  }

  public void put_VerboseLogging(boolean newVal) {
    chilkatJNI.CkTaskChain_put_VerboseLogging(swigCPtr, this, newVal);
  }

  public void get_Version(CkString str) {
    chilkatJNI.CkTaskChain_get_Version(swigCPtr, this, CkString.getCPtr(str), str);
  }

  public String version() {
    return chilkatJNI.CkTaskChain_version(swigCPtr, this);
  }

  public boolean Append(CkTask task) {
    return chilkatJNI.CkTaskChain_Append(swigCPtr, this, CkTask.getCPtr(task), task);
  }

  public boolean Cancel() {
    return chilkatJNI.CkTaskChain_Cancel(swigCPtr, this);
  }

  public CkTask GetTask(int index) {
    long cPtr = chilkatJNI.CkTaskChain_GetTask(swigCPtr, this, index);
    return (cPtr == 0) ? null : new CkTask(cPtr, true);
  }

  public boolean Run() {
    return chilkatJNI.CkTaskChain_Run(swigCPtr, this);
  }

  public boolean RunSynchronously() {
    return chilkatJNI.CkTaskChain_RunSynchronously(swigCPtr, this);
  }

  public boolean SaveLastError(String path) {
    return chilkatJNI.CkTaskChain_SaveLastError(swigCPtr, this, path);
  }

  public void SleepMs(int numMs) {
    chilkatJNI.CkTaskChain_SleepMs(swigCPtr, this, numMs);
  }

  public boolean Wait(int maxWaitMs) {
    return chilkatJNI.CkTaskChain_Wait(swigCPtr, this, maxWaitMs);
  }

}
