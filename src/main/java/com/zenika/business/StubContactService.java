package com.zenika.business;

import com.zenika.Contact;

import java.util.*;

/**
 *
 *
 */
public class StubContactService implements ContactService {

    private final Map<Long,Contact> contacts = new LinkedHashMap<Long, Contact>() {{
        put(1L,new Contact(1L,"John","Doe"));
        put(2L,new Contact(2L,"Jane","Doe"));
    }};

    @Override
    public List<Contact> getContacts() {
        return new ArrayList<Contact>(contacts.values());
    }
}
