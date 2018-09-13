
// Provide a default path to dwr.engine
if (dwr == null) var dwr = {};
if (dwr.engine == null) dwr.engine = {};
if (DWREngine == null) var DWREngine = dwr.engine;

if (DWRAction == null) var DWRAction = {};
DWRAction._path = '/dwr';
DWRAction.wait = function(callback) {
  dwr.engine._execute(DWRAction._path, 'DWRAction', 'wait', callback);
}
DWRAction.wait = function(p0, p1, callback) {
  dwr.engine._execute(DWRAction._path, 'DWRAction', 'wait', p0, p1, callback);
}
DWRAction.wait = function(p0, callback) {
  dwr.engine._execute(DWRAction._path, 'DWRAction', 'wait', p0, callback);
}
DWRAction.notifyAll = function(callback) {
  dwr.engine._execute(DWRAction._path, 'DWRAction', 'notifyAll', callback);
}
DWRAction.notify = function(callback) {
  dwr.engine._execute(DWRAction._path, 'DWRAction', 'notify', callback);
}
DWRAction.toString = function(callback) {
  dwr.engine._execute(DWRAction._path, 'DWRAction', 'toString', callback);
}
DWRAction.equals = function(p0, callback) {
  dwr.engine._execute(DWRAction._path, 'DWRAction', 'equals', p0, callback);
}
DWRAction.hashCode = function(callback) {
  dwr.engine._execute(DWRAction._path, 'DWRAction', 'hashCode', callback);
}
DWRAction.getClass = function(callback) {
  dwr.engine._execute(DWRAction._path, 'DWRAction', 'getClass', callback);
}
DWRAction.execute = function(p0, p1, callback) {
  dwr.engine._execute(DWRAction._path, 'DWRAction', 'execute', p0, p1, false, false, false, callback);
}
