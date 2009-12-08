/*
 * Copyright 2009 University Corporation for Advanced Internet Development, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.openxrd.xrd.core.impl;

import org.opensaml.xml.XMLObject;
import org.opensaml.xml.io.MarshallingException;
import org.opensaml.xml.util.XMLHelper;
import org.openxrd.xrd.common.impl.AbstractXRDObjectMarshaller;
import org.openxrd.xrd.core.Title;
import org.w3c.dom.Element;

/**
 * A thread-safe marshaller for {@link Title}.
 */
public class TitleMarshaller extends AbstractXRDObjectMarshaller {

    /** {@inheritDoc} */
    protected void marshallAttributes(XMLObject xmlObject, Element domElement) throws MarshallingException {
        Title title = (Title) xmlObject;

        if (title.getLanguage() != null) {
            domElement.setAttributeNS(Title.LANG_ATTRIB_NAME.getNamespaceURI(), Title.LANG_ATTRIB_NAME.getPrefix()
                    + ":" + Title.LANG_ATTRIB_NAME.getLocalPart(), title.getLanguage());
        }

        super.marshallAttributes(xmlObject, domElement);
    }

    /** {@inheritDoc} */
    protected void marshallElementContent(XMLObject xmlObject, Element domElement) throws MarshallingException {
        Title title = (Title) xmlObject;

        if (title.getValue() != null) {
            XMLHelper.appendTextContent(domElement, title.getValue());
        }
    }

}