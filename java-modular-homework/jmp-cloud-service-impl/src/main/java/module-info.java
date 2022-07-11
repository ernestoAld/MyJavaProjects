module jmp.cloud.service.impl {
    requires transitive jmp.service.api;
    requires jmp.dto;
    exports com.modular.service.impl;
    //Creation of the provider
    provides com.modular.serviceapi.IService with com.modular.service.impl.ServiceImpl;
}