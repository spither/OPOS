package com.bioregional.opap

class BaseDataService {

    void checkRoles() {
        Role.findOrSaveWhere(authority: 'ROLE_USER')
        Role.findOrSaveWhere(authority: 'ROLE_COMMENT_MOD')
    }

    void checkActionCategories() {
        ActionCategory.findOrSaveWhere(code: 'carbon', name: 'Zero Carbon')
        ActionCategory.findOrSaveWhere(code: 'waste', name: 'Zero Waste')
        ActionCategory.findOrSaveWhere(code: 'transport', name: 'Sustainable transport')
        ActionCategory.findOrSaveWhere(code: 'materials', name: 'Sustainable materials')
        ActionCategory.findOrSaveWhere(code: 'food', name: 'Local and sustainable food')
        ActionCategory.findOrSaveWhere(code: 'water', name: 'Sustainable water')
        ActionCategory.findOrSaveWhere(code: 'land', name: 'Land and wildlife')
        ActionCategory.findOrSaveWhere(code: 'culture', name: 'Culture and community')
        ActionCategory.findOrSaveWhere(code: 'equity', name: 'Equity and local economy')
        ActionCategory.findOrSaveWhere(code: 'health', name: 'Health and happiness')
    }
}
