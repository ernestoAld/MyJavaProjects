module jmp.cloud.bank.impl {
    requires transitive jmp.bank.api;
    requires jmp.dto;
    exports com.modular.cloudbankimpl;
    //Creation of the provider
    provides com.modular.bankapi.IBank with com.modular.cloudbankimpl.BankImpl;
}