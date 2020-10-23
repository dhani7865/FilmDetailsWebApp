/**
 * FilmSoapBindingSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.daehosting.webservices.film;

public class FilmSoapBindingSkeleton implements com.daehosting.webservices.film.FilmSoapType, org.apache.axis.wsdl.Skeleton {
    private com.daehosting.webservices.film.FilmSoapType impl;
    private static java.util.Map _myOperations = new java.util.Hashtable();
    private static java.util.Collection _myOperationsList = new java.util.ArrayList();

    /**
    * Returns List of OperationDesc objects with this name
    */
    public static java.util.List getOperationDescByName(java.lang.String methodName) {
        return (java.util.List)_myOperations.get(methodName);
    }

    /**
    * Returns Collection of OperationDescs
    */
    public static java.util.Collection getOperationDescs() {
        return _myOperationsList;
    }

    static {
        org.apache.axis.description.OperationDesc _oper;
        org.apache.axis.description.FaultDesc _fault;
        org.apache.axis.description.ParameterDesc [] _params;
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://webservices.daehosting.com/film", "FilmsList"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("filmsList", _params, new javax.xml.namespace.QName("http://webservices.daehosting.com/film", "FilmsListResponse"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        _oper.setElementQName(new javax.xml.namespace.QName("", "FilmsList"));
        _oper.setSoapAction("http://webservices.daehosting.com/film/FilmsList");
        _myOperationsList.add(_oper);
        if (_myOperations.get("filmsList") == null) {
            _myOperations.put("filmsList", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("filmsList")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://webservices.daehosting.com/film", "FilmsListXML"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("filmsXML", _params, new javax.xml.namespace.QName("http://webservices.daehosting.com/film", "FilmsListXMLResponse"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        _oper.setElementQName(new javax.xml.namespace.QName("", "FilmsXML"));
        _oper.setSoapAction("http://webservices.daehosting.com/film/FilmsXML");
        _myOperationsList.add(_oper);
        if (_myOperations.get("filmsXML") == null) {
            _myOperations.put("filmsXML", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("filmsXML")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://webservices.daehosting.com/film", "FilmsListJSON"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("filmsJSON", _params, new javax.xml.namespace.QName("http://webservices.daehosting.com/film", "FilmsListJSONResponse"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        _oper.setElementQName(new javax.xml.namespace.QName("", "FilmsJSON"));
        _oper.setSoapAction("http://webservices.daehosting.com/film/FilmsJSON");
        _myOperationsList.add(_oper);
        if (_myOperations.get("filmsJSON") == null) {
            _myOperations.put("filmsJSON", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("filmsJSON")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://webservices.daehosting.com/film", "FilmsListString"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("filmsString", _params, new javax.xml.namespace.QName("http://webservices.daehosting.com/film", "FilmsListStringResponse"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        _oper.setElementQName(new javax.xml.namespace.QName("", "FilmsString"));
        _oper.setSoapAction("http://webservices.daehosting.com/film/FilmsString");
        _myOperationsList.add(_oper);
        if (_myOperations.get("filmsString") == null) {
            _myOperations.put("filmsString", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("filmsString")).add(_oper);
    }

    public FilmSoapBindingSkeleton() {
        this.impl = new com.daehosting.webservices.film.FilmSoapBindingImpl();
    }

    public FilmSoapBindingSkeleton(com.daehosting.webservices.film.FilmSoapType impl) {
        this.impl = impl;
    }
    public java.lang.String filmsList(java.lang.String parameters) throws java.rmi.RemoteException
    {
        java.lang.String ret = impl.filmsList(parameters);
        return ret;
    }

    public java.lang.String filmsXML(java.lang.String parameters) throws java.rmi.RemoteException
    {
        java.lang.String ret = impl.filmsXML(parameters);
        return ret;
    }

    public java.lang.String filmsJSON(java.lang.String parameters) throws java.rmi.RemoteException
    {
        java.lang.String ret = impl.filmsJSON(parameters);
        return ret;
    }

    public java.lang.String filmsString(java.lang.String parameters) throws java.rmi.RemoteException
    {
        java.lang.String ret = impl.filmsString(parameters);
        return ret;
    }

}
