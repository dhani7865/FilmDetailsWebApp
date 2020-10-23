function makeParamString(id1, id2, format) {
  var paramString =
    "id1=" + getValue(id1) + 
    "&format=" + format;
  return(paramString);
}