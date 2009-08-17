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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.xml.namespace.QName;

import org.opensaml.xml.XMLObject;
import org.opensaml.xml.util.IndexedXMLObjectChildrenList;
import org.openxrd.xrd.common.impl.AbstractXRDObject;
import org.openxrd.xrd.core.Link;
import org.openxrd.xrd.core.MediaType;
import org.openxrd.xrd.core.Rel;
import org.openxrd.xrd.core.TargetAuthority;
import org.openxrd.xrd.core.URI;
import org.openxrd.xrd.core.URITemplate;

/**
 * A concrete implementation of {@link Link}.
 */
public class LinkImpl extends AbstractXRDObject implements Link {

    /** Priority. */
    private int priority;

    /** Rels. */
    private List<Rel> rels;

    /** Media Types. */
    private List<MediaType> mediaTypes;

    /** URIs. */
    private List<URI> uris;

    /** URITemplates. */
    private List<URITemplate> uriTemplates;

    /** Target Authority. */
    private TargetAuthority targetAuthority;

    /** Unknown children of this element. */
    private IndexedXMLObjectChildrenList<XMLObject> unknownElements;

    /**
     * Constructor.
     * 
     * @param namespaceURI the namespace the element is in
     * @param elementLocalName the local name of the XML element this Object represents
     * @param namespacePrefix the prefix for the given namespace
     */
    public LinkImpl(String namespaceURI, String elementLocalName, String namespacePrefix) {
        super(namespaceURI, elementLocalName, namespacePrefix);

        mediaTypes = new ArrayList<MediaType>();
        rels = new ArrayList<Rel>();
        uris = new ArrayList<URI>();
        uriTemplates = new ArrayList<URITemplate>();
        unknownElements = new IndexedXMLObjectChildrenList<XMLObject>(this);
    }

    /** {@inheritDoc} */
    public int getPriority() {
        return priority;
    }

    /** {@inheritDoc} */
    public void setPriority(int newPriority) {
        priority = prepareForAssignment(priority, newPriority);
    }

    /** {@inheritDoc} */
    public List<Rel> getRels() {
        return rels;
    }

    /** {@inheritDoc} */
    public List<MediaType> getMediaTypes() {
        return mediaTypes;
    }

    /** {@inheritDoc} */
    public List<URI> getURIs() {
        return uris;
    }

    /** {@inheritDoc} */
    public List<URITemplate> getURITemplates() {
        return uriTemplates;
    }

    /** {@inheritDoc} */
    public TargetAuthority getTargetAuthority() {
        return targetAuthority;
    }

    /** {@inheritDoc} */
    public void setTargetAuthority(TargetAuthority newTargetAuthority) {
        targetAuthority = prepareForAssignment(targetAuthority, newTargetAuthority);
    }

    /** {@inheritDoc} */
    public List<XMLObject> getOrderedChildren() {
        ArrayList<XMLObject> children = new ArrayList<XMLObject>();
        
        children.addAll(getRels());
        children.addAll(getMediaTypes());
        children.addAll(getURIs());
        children.addAll(getURITemplates());
        if (getTargetAuthority() != null) {
            children.add(getTargetAuthority());
        }
        
        children.addAll(getUnknownXMLObjects());
        
        return Collections.unmodifiableList(children);
    }

    /** {@inheritDoc} */
    public List<XMLObject> getUnknownXMLObjects() {
        return unknownElements;
    }

    /** {@inheritDoc} */
    public List<XMLObject> getUnknownXMLObjects(QName typeOrName) {
        return (List<XMLObject>) unknownElements.subList(typeOrName);
    }

}