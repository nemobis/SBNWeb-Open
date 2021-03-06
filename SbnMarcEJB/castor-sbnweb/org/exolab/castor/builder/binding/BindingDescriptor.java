/*
 * This class was automatically generated with
 * <a href="http://castor.exolab.org">Castor 0.9.4</a>, using an
 * XML Schema.
 * $Id: BindingDescriptor.java,v 1.1 2011/04/13 14:25:01 almaviva5 Exp $
 */

package org.exolab.castor.builder.binding;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import org.exolab.castor.xml.*;
import org.exolab.castor.xml.FieldValidator;
import org.exolab.castor.xml.handlers.*;
import org.exolab.castor.xml.util.XMLFieldDescriptorImpl;

/**
 *
 *
 * @version $Revision: 1.1 $ $Date: 2011/04/13 14:25:01 $
**/
public class BindingDescriptor extends org.exolab.castor.xml.util.XMLClassDescriptorImpl {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    private java.lang.String nsPrefix;

    private java.lang.String nsURI;

    private java.lang.String xmlName;

    private org.exolab.castor.xml.XMLFieldDescriptor identity;


      //----------------/
     //- Constructors -/
    //----------------/

    public BindingDescriptor() {
        super();
        nsURI = "http://www.castor.org/SourceGenerator/Binding";
        xmlName = "binding";

        //-- set grouping compositor
        setCompositorAsSequence();
        XMLFieldDescriptorImpl  desc           = null;
        XMLFieldHandler         handler        = null;
        FieldValidator          fieldValidator = null;
        //-- initialize attribute descriptors

        //-- _defaultBindingType
        desc = new XMLFieldDescriptorImpl(org.exolab.castor.builder.binding.types.BindingType.class, "_defaultBindingType", "defaultBindingType", NodeType.Attribute);
        handler = (new XMLFieldHandler() {
            public java.lang.Object getValue( java.lang.Object object )
                throws IllegalStateException
            {
                Binding target = (Binding) object;
                return target.getDefaultBindingType();
            }
            public void setValue( java.lang.Object object, java.lang.Object value)
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    Binding target = (Binding) object;
                    target.setDefaultBindingType( (org.exolab.castor.builder.binding.types.BindingType) value);
                }
                catch (Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public java.lang.Object newInstance( java.lang.Object parent ) {
                return null;
            }
        } );
        desc.setHandler( new EnumFieldHandler(org.exolab.castor.builder.binding.types.BindingType.class, handler));
        desc.setImmutable(true);
        addFieldDescriptor(desc);

        //-- validation code for: _defaultBindingType
        fieldValidator = new FieldValidator();
        desc.setValidator(fieldValidator);

        //-- initialize element descriptors

        //-- _includeList
        desc = new XMLFieldDescriptorImpl(IncludeType.class, "_includeList", "include", NodeType.Element);
        handler = (new XMLFieldHandler() {
            public java.lang.Object getValue( java.lang.Object object )
                throws IllegalStateException
            {
                Binding target = (Binding) object;
                return target.getInclude();
            }
            public void setValue( java.lang.Object object, java.lang.Object value)
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    Binding target = (Binding) object;
                    target.addInclude( (IncludeType) value);
                }
                catch (Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public java.lang.Object newInstance( java.lang.Object parent ) {
                return new IncludeType();
            }
        } );
        desc.setHandler(handler);
        desc.setNameSpaceURI("http://www.castor.org/SourceGenerator/Binding");
        desc.setMultivalued(true);
        addFieldDescriptor(desc);

        //-- validation code for: _includeList
        fieldValidator = new FieldValidator();
        fieldValidator.setMinOccurs(0);
        desc.setValidator(fieldValidator);

        //-- _packageList
        desc = new XMLFieldDescriptorImpl(PackageType.class, "_packageList", "package", NodeType.Element);
        handler = (new XMLFieldHandler() {
            public java.lang.Object getValue( java.lang.Object object )
                throws IllegalStateException
            {
                Binding target = (Binding) object;
                return target.getPackage();
            }
            public void setValue( java.lang.Object object, java.lang.Object value)
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    Binding target = (Binding) object;
                    target.addPackage( (PackageType) value);
                }
                catch (Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public java.lang.Object newInstance( java.lang.Object parent ) {
                return new PackageType();
            }
        } );
        desc.setHandler(handler);
        desc.setNameSpaceURI("http://www.castor.org/SourceGenerator/Binding");
        desc.setMultivalued(true);
        addFieldDescriptor(desc);

        //-- validation code for: _packageList
        fieldValidator = new FieldValidator();
        fieldValidator.setMinOccurs(0);
        desc.setValidator(fieldValidator);

        //-- _namingXML
        desc = new XMLFieldDescriptorImpl(NamingXMLType.class, "_namingXML", "namingXML", NodeType.Element);
        handler = (new XMLFieldHandler() {
            public java.lang.Object getValue( java.lang.Object object )
                throws IllegalStateException
            {
                Binding target = (Binding) object;
                return target.getNamingXML();
            }
            public void setValue( java.lang.Object object, java.lang.Object value)
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    Binding target = (Binding) object;
                    target.setNamingXML( (NamingXMLType) value);
                }
                catch (Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public java.lang.Object newInstance( java.lang.Object parent ) {
                return new NamingXMLType();
            }
        } );
        desc.setHandler(handler);
        desc.setNameSpaceURI("http://www.castor.org/SourceGenerator/Binding");
        desc.setMultivalued(false);
        addFieldDescriptor(desc);

        //-- validation code for: _namingXML
        fieldValidator = new FieldValidator();
        desc.setValidator(fieldValidator);

        //-- _elementBindingList
        desc = new XMLFieldDescriptorImpl(ComponentBindingType.class, "_elementBindingList", "elementBinding", NodeType.Element);
        handler = (new XMLFieldHandler() {
            public java.lang.Object getValue( java.lang.Object object )
                throws IllegalStateException
            {
                Binding target = (Binding) object;
                return target.getElementBinding();
            }
            public void setValue( java.lang.Object object, java.lang.Object value)
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    Binding target = (Binding) object;
                    target.addElementBinding( (ComponentBindingType) value);
                }
                catch (Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public java.lang.Object newInstance( java.lang.Object parent ) {
                return new ComponentBindingType();
            }
        } );
        desc.setHandler(handler);
        desc.setNameSpaceURI("http://www.castor.org/SourceGenerator/Binding");
        desc.setMultivalued(true);
        addFieldDescriptor(desc);

        //-- validation code for: _elementBindingList
        fieldValidator = new FieldValidator();
        fieldValidator.setMinOccurs(0);
        desc.setValidator(fieldValidator);

        //-- _attributeBindingList
        desc = new XMLFieldDescriptorImpl(ComponentBindingType.class, "_attributeBindingList", "attributeBinding", NodeType.Element);
        handler = (new XMLFieldHandler() {
            public java.lang.Object getValue( java.lang.Object object )
                throws IllegalStateException
            {
                Binding target = (Binding) object;
                return target.getAttributeBinding();
            }
            public void setValue( java.lang.Object object, java.lang.Object value)
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    Binding target = (Binding) object;
                    target.addAttributeBinding( (ComponentBindingType) value);
                }
                catch (Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public java.lang.Object newInstance( java.lang.Object parent ) {
                return new ComponentBindingType();
            }
        } );
        desc.setHandler(handler);
        desc.setNameSpaceURI("http://www.castor.org/SourceGenerator/Binding");
        desc.setMultivalued(true);
        addFieldDescriptor(desc);

        //-- validation code for: _attributeBindingList
        fieldValidator = new FieldValidator();
        fieldValidator.setMinOccurs(0);
        desc.setValidator(fieldValidator);

        //-- _complexTypeBindingList
        desc = new XMLFieldDescriptorImpl(ComponentBindingType.class, "_complexTypeBindingList", "complexTypeBinding", NodeType.Element);
        handler = (new XMLFieldHandler() {
            public java.lang.Object getValue( java.lang.Object object )
                throws IllegalStateException
            {
                Binding target = (Binding) object;
                return target.getComplexTypeBinding();
            }
            public void setValue( java.lang.Object object, java.lang.Object value)
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    Binding target = (Binding) object;
                    target.addComplexTypeBinding( (ComponentBindingType) value);
                }
                catch (Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public java.lang.Object newInstance( java.lang.Object parent ) {
                return new ComponentBindingType();
            }
        } );
        desc.setHandler(handler);
        desc.setNameSpaceURI("http://www.castor.org/SourceGenerator/Binding");
        desc.setMultivalued(true);
        addFieldDescriptor(desc);

        //-- validation code for: _complexTypeBindingList
        fieldValidator = new FieldValidator();
        fieldValidator.setMinOccurs(0);
        desc.setValidator(fieldValidator);

        //-- _groupBindingList
        desc = new XMLFieldDescriptorImpl(ComponentBindingType.class, "_groupBindingList", "groupBinding", NodeType.Element);
        handler = (new XMLFieldHandler() {
            public java.lang.Object getValue( java.lang.Object object )
                throws IllegalStateException
            {
                Binding target = (Binding) object;
                return target.getGroupBinding();
            }
            public void setValue( java.lang.Object object, java.lang.Object value)
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    Binding target = (Binding) object;
                    target.addGroupBinding( (ComponentBindingType) value);
                }
                catch (Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public java.lang.Object newInstance( java.lang.Object parent ) {
                return new ComponentBindingType();
            }
        } );
        desc.setHandler(handler);
        desc.setNameSpaceURI("http://www.castor.org/SourceGenerator/Binding");
        desc.setMultivalued(true);
        addFieldDescriptor(desc);

        //-- validation code for: _groupBindingList
        fieldValidator = new FieldValidator();
        fieldValidator.setMinOccurs(0);
        desc.setValidator(fieldValidator);

    } //-- org.exolab.castor.builder.binding.BindingDescriptor()


      //-----------/
     //- Methods -/
    //-----------/

    /**
    **/
    public org.exolab.castor.mapping.AccessMode getAccessMode()
    {
        return null;
    } //-- org.exolab.castor.mapping.AccessMode getAccessMode()

    /**
    **/
    public org.exolab.castor.mapping.ClassDescriptor getExtends()
    {
        return null;
    } //-- org.exolab.castor.mapping.ClassDescriptor getExtends()

    /**
    **/
    public org.exolab.castor.mapping.FieldDescriptor getIdentity()
    {
        return identity;
    } //-- org.exolab.castor.mapping.FieldDescriptor getIdentity()

    /**
    **/
    public java.lang.Class getJavaClass()
    {
        return org.exolab.castor.builder.binding.Binding.class;
    } //-- java.lang.Class getJavaClass()

    /**
    **/
    public java.lang.String getNameSpacePrefix()
    {
        return nsPrefix;
    } //-- java.lang.String getNameSpacePrefix()

    /**
    **/
    public java.lang.String getNameSpaceURI()
    {
        return nsURI;
    } //-- java.lang.String getNameSpaceURI()

    /**
    **/
    public org.exolab.castor.xml.TypeValidator getValidator()
    {
        return this;
    } //-- org.exolab.castor.xml.TypeValidator getValidator()

    /**
    **/
    public java.lang.String getXMLName()
    {
        return xmlName;
    } //-- java.lang.String getXMLName()

}
