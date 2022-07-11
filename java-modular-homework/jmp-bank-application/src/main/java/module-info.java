module jmp.bank.application {
    requires jmp.dto;
    requires jmp.cloud.bank.impl;
    requires jmp.cloud.service.impl;
    uses com.modular.serviceapi.IService;
    uses com.modular.bankapi.IBank;
}