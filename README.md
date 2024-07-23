init (ExternalCall)
  |
  |--[Transition: entitlements]
  |
entitlements (ExternalCall)
  |  
  |--[AreParametersInvalid]: something-went-wrong
  |--[IsExternalCallHandlerFailure]: system-down
  |--[AreEntitlementsNotAsRequired]: invalid-access
  |--Default: splash
  |
splash (CollectData)
  |
  |--[IsAuthContactsActive]: get-authorized-contacts
  |--Default: getVerticals
  |
get-authorized-contacts (ExternalCall)
  |
  |--Default: getVerticals
  |
getVerticals (ExternalCall)
  |
  |--[IsExternalCallHandlerFailure]: system-down
  |--[IsGoTOReviewOrderPage]: review-order-session
  |--Default: get-started
  |
review-order-session (ExternalCall)
  |
  |--[IsNcrProductFeatureEnabled]: order-review-rulehandler
  |--[IsExternalCallHandlerFailure]: system-down
  |--Default: review-order
  |
order-review-rulehandler (ExternalCall)
  |
  |--[IsExternalCallHandlerFailure]: system-down
  |--Default: review-order
  |
get-started (CollectData)
  |
  |--Default: business-questionnaire
  |
business-questionnaire (CollectData)
  |
  |--Default: getPricingOptions
  |
getPricingOptions (ExternalCall)
  |
  |--[IsExternalCallHandlerFailure]: system-down
  |--Default: pricing-options
  |
pricing-options (CollectData)
  |
  |--Default: getEProductData
  |
getEProductData (ExternalCall)
  |
  |--[IsExternalCallHandlerFailure]: system-down
  |--Default: return-bundle-options
  |
return-bundle-options (CollectData)
  |
  |--[IsBYOBFlow]: retrieve-software-list
  |--Default: bundle-details
  |
retrieve-software-list (ExternalCall)
  |
  |--[IsExternalCallHandlerFailure]: system-down
  |--Default: byob-software
  |
byob-software (CollectData)
  |
  |--[IsGoToByobSoftwareFlow]: byob-software
  |--[IsKdsEnabled]: byob-vas-and-cds
  |--Default: byob-value-added-services
  |
byob-value-added-services (CollectData)
  |
  |--Default: byob-peripherals
  |
byob-vas-and-cds (CollectData)
  |
  |--Default: byob-peripherals
  |
byob-peripherals (CollectData)
  |
  |--Default: byob-hardware-peripherals
  |
byob-hardware-peripherals (CollectData)
  |
  |--Default: byob-accessories
  |
byob-accessories (CollectData)
  |
  |--[IsNcrProductFeatureEnabled]: product-rules
  |--Default: payment-configurations-session
  |
bundle-details (CollectData)
  |
  |--[IsNcrProductFeatureEnabled]: product-rules
  |--Default: payment-configurations-session
  |
product-rules (ExternalCall)
  |
  |--Default: payment-configurations-session
  |
payment-configurations-session (ExternalCall)
  |
  |--[IsExternalCallHandlerFailure]: system-down
  |--Default: payment-configurations
  |
payment-configurations (CollectData)
  |
  |--Default: review-order
  |
review-order (CollectData)
  |
  |--[IsGoToExit]: save-and-exit
  |--[IsGoToRemoveLocationFlow]: review-order
  |--[IsGoToChangeVerticalFlow]: get-started
  |--[IsGoToEditSolutionOrAddLocationFlow]: business-questionnaire
  |--[IsMaxHardwareOrPeripherals]: review-order
  |--[IsAnyLocationHavingInvalidData]: review-order
  |--Default: submissionCallProductCatalogReviewOrder
  |
submissionCallProductCatalogReviewOrder (ExternalCall)
  |
  |--[IsGoToSaveAndExit]: submissionSaveAndExit
  |--[IsVerifyEmailEnabled]: fetchAuthHubValidationTokenForBusinessEmail
  |--Default: business-overview
  |
business-overview (CollectData)
  |
  |--Default: submissionCallBusinessOverview
  |
submissionCallBusinessOverview (ExternalCall)
  |
  |--[IsGoToSaveAndExit]: submissionSaveAndExit
  |--[IsEmailVerifiedSuccess]: business-activities
  |--Default: system-down
  |
business-activities (CollectData)
  |
  |--Default: submissionCallBusinessActivities
  |
submissionCallBusinessActivities (ExternalCall)
  |
  |--[IsGoToSaveAndExit]: submissionSaveAndExit
  |--[IsVerifyEmailOrNCRMobileEnabledAndGuarantorPresent]: fetchAuthHubValidationTokenForGuarantorEmail
  |--Default: applicant
  |
fetchAuthHubValidationTokenForGuarantorEmail (ExternalCall)
  |
  |--Default: applicant
  |
applicant (CollectData)
  |
  |--Default: submissionCallGuarantor
  |
submissionCallGuarantor (ExternalCall)
  |
  |--[IsGoToSaveAndExit]: submissionSaveAndExit
  |--[IsEmailVerifiedSuccess]: ownership
  |--Default: system-down
  |
ownership (CollectData)
  |
  |--Default: submissionCallOwnership
  |
submissionCallOwnership (ExternalCall)
  |
  |--[IsGoToSaveAndExit]: submissionSaveAndExit
  |--Default: authorized-contacts
  |
authorized-contacts (CollectData)
  |
  |--Default: submissionCallAuthContacts
  |
submissionCallAuthContacts (ExternalCall)
  |
  |--[IsGoToSaveAndExit]: submissionSaveAndExit
  |--Default: locations
  |
locations (CollectData)
  |
  |--Default: submissionCallLocations
  |
submissionCallLocations (ExternalCall)
  |
  |--[IsGoToSaveAndExit]: submissionSaveAndExit
  |--Default: settlement
  |
settlement (CollectData)
  |
  |--Default: submissionCallSettlement
  |
submissionCallSettlement (ExternalCall)
  |
  |--[IsGoToSaveAndExit]: submissionSaveAndExit
  |--Default: retrieve-shipping-details
  |
retrieve-shipping-details (ExternalCall)
  |
  |--[IsExternalCallHandlerFailure]: system-down
  |--Default: application-review-order
  |
application-review-order (CollectData)
  |
  |--Default: submissionApplicationReviewOrder
  |
submissionApplicationReviewOrder (ExternalCall)
  |
  |--[IsGoToReferToSpecialist]: screener-questions
  |--[IsGoToSaveAndExit]: submissionSaveAndExit
  |--Default: disclosure
  |
disclosure (CollectData)
  |
  |--Default: submissionCallFinal
  |
submissionCallFinal (ExternalCall)
  |
  |--[IsGoToSaveAndExit]: submissionSaveAndExit
  |--Default: submitApplication
  |
submitApplication (ExternalCall)
  |
  |--[IsExternalCallHandlerFailure]: system-down
  |--Default: waiting-screen
  |
waiting-screen (CollectData)
  |
  |--Default: applicationSubmittedHandler
  |
applicationSubmittedHandler (ExternalCall)
  |
  |--Default: application-submitted
  |
application-submitted (CollectData)

Common Routes Definition:
  submissionSaveAndExit (ExternalCall)
    |--SaveCEHEventCallHandler
    |--CNESavedAppEmailCallHandler
    |--Default: save-and-exit





    Sure, let's analyze the flow from one handler to another in the given XML definition.

### Flow Breakdown

1. **Initial Step (init)**
    - Handlers: Loginlaas EventCallHandler, FlowInitializationIaas EventCallHandler
    - Next Step: entitlements

2. **Entitlements (entitlements)**
    - Handler: VerifyUserEntitlementsCallHandler
    - Transitions:
        - On AreParametersInvalid: something-went-wrong
        - On IsExternalCallHandlerFailure: system-down
        - On AreEntitlementsNotAsRequired: invalid-access
        - Default: splash

3. **Splash (splash)**
    - Mapper: bbSplashDomainMapperImpl
    - Transitions:
        - On IsAuthContactsActive: get-authorized-contacts
        - Default: getVerticals

4. **Get Authorized Contacts (get-authorized-contacts)**
    - Handler: ExistingAuthContactsHandler
    - Next Step: getVerticals

5. **Get Verticals (getVerticals)**
    - Handler: VerticalsSessionCallHandler
    - Transitions:
        - On IsExternalCallHandlerFailure: system-down
        - On IsGoTOReviewOrderPage: review-order-session
        - Default: get-started

6. **Review Order Session (review-order-session)**
    - Handlers: ValidateSNRCallHandler, SNRRuleHandler
    - Transitions:
        - On IsNcrProductFeatureEnabled: order-review-rulehandler
        - On IsExternalCallHandlerFailure: system-down
        - Default: review-order

7. **Order Review Rule Handler (order-review-rulehandler)**
    - Handler: RuleHandler
    - Transitions:
        - On IsExternalCallHandlerFailure: system-down
        - Default: review-order

8. **Get Started (get-started)**
    - Mapper: sfGetStartedDomainMapper
    - Next Step: business-questionnaire

9. **Business Questionnaire (business-questionnaire)**
    - Mapper: sfBusinessQuestionnaireDomainMapper
    - Next Step: getPricingOptions

10. **Get Pricing Options (getPricingOptions)**
    - Handler: PricingOptionSessionCallHandler
    - Transitions:
        - On IsExternalCallHandlerFailure: system-down
        - Default: pricing-options

11. **Pricing Options (pricing-options)**
    - Mapper: sfPricingOptionDomainMapper
    - Next Step: getEProductData

12. **Get EProduct Data (getEProductData)**
    - Handler: EProductBundleCallHandler
    - Transitions:
        - On IsExternalCallHandlerFailure: system-down
        - Default: return-bundle-options

13. **Return Bundle Options (return-bundle-options)**
    - Mapper: sfReturnBundleOptionDomainMapper
    - Transitions:
        - On IsBYOBFlow: retrieve-software-list
        - Default: bundle-details

14. **Retrieve Software List (retrieve-software-list)**
    - Handler: RetrieveSoftwareListCallHandler
    - Transitions:
        - On IsExternalCallHandlerFailure: system-down
        - Default: byob-software

15. **BYOB Software (byob-software)**
    - Mapper: sfByobSoftwareDomainMapper
    - Transitions:
        - On IsGoToByobSoftwareFlow: byob-software
        - On IsKdsEnabled: byob-vas-and-cds
        - Default: byob-value-added-services

16. **BYOB Value-Added Services (byob-value-added-services)**
    - Mapper: sfByobValueAddedServiceDomainMapper
    - Next Step: byob-peripherals

17. **BYOB VAS and CDS (byob-vas-and-cds)**
    - Mapper: sfByobVasAndCdsDomainMapper
    - Next Step: byob-peripherals

18. **BYOB Peripherals (byob-peripherals)**
    - Mapper: sfByobPeripheralsDomainMapper
    - Next Step: byob-hardware-peripherals

19. **BYOB Hardware Peripherals (byob-hardware-peripherals)**
    - Mapper: sfByobHardwarePeripheralsDomainMapper
    - Next Step: byob-accessories

20. **BYOB Accessories (byob-accessories)**
    - Mapper: sfByobAccessoryDomainMapper
    - Transitions:
        - On IsNcrProductFeatureEnabled: product-rules
        - Default: payment-configurations-session

21. **Bundle Details (bundle-details)**
    - Mapper: sfBundleDetailsDomainMapper
    - Transitions:
        - On IsNcrProductFeatureEnabled: product-rules
        - Default: payment-configurations-session

22. **Product Rules (product-rules)**
    - Handler: RuleHandler
    - Next Step: payment-configurations-session

23. **Payment Configurations Session (payment-configurations-session)**
    - Handler: PaymentConfigurationsSessionCallHandler
    - Transitions:
        - On IsExternalCallHandlerFailure: system-down
        - Default: payment-configurations

24. **Payment Configurations (payment-configurations)**
    - Mapper: sfPaymentConfigurationDomainMapper
    - Next Step: review-order

25. **Review Order (review-order)**
    - Mapper: bbPCReviewOrderDomainMapper
    - Transitions:
        - On IsGoToExit: save-and-exit
        - On IsGoToRemoveLocationFlow: review-order
        - On IsGoToChangeVerticalFlow: get-started
        - On IsGoToEditSolutionOrAddLocationFlow: business-questionnaire
        - On IsMaxHardwareOrPeripherals: review-order
        - On IsAnyLocationHavingInvalidData: review-order
        - Default: submissionCallProductCatalogReviewOrder

26. **Submission Call Product Catalog Review Order (submissionCallProductCatalogReviewOrder)**
    - Handlers: SaveOrUpdateApplicationCallHandler, StartCEHEventCallHandler
    - Transitions:
        - On IsGoToSaveAndExit: submissionSaveAndExit
        - On IsVerifyEmailEnabled: fetchAuthHubValidationTokenForBusinessEmail
        - Default: business-overview

27. **Business Overview (business-overview)**
    - Mapper: bbBusinessOverviewDomainMapper
    - Next Step: submissionCallBusinessOverview

28. **Submission Call Business Overview (submissionCallBusinessOverview)**
    - Handler: SaveOrUpdateApplicationCallHandler
    - Transitions:
        - On IsGoToSaveAndExit: submissionSaveAndExit
        - On IsEmailVerifiedSuccess: business-activities
        - Default: system-down

29. **Business Activities (business-activities)**
    - Mapper: sfBusinessActivityDomainMapper
    - Next Step: submissionCallBusinessActivities

30. **Submission Call Business Activities (submissionCallBusinessActivities)**
    - Handler: SaveOrUpdateApplicationCallHandler
    - Transitions:
        - On IsGoToSaveAndExit: submissionSaveAndExit
        - On IsVerifyEmailOrNCRMobileEnabledAndGuarantorPresent: fetchAuthHubValidationTokenForGuarantorEmail
        - Default: applicant

31. **Fetch Auth Hub Validation Token for Guarantor Email (fetchAuthHubValidationTokenForGuarantorEmail)**
    - Handler: GuarantorCreateAuthHubOTTCallHandler
    - Next Step: applicant

32. **Applicant (applicant)**
    - Mapper: bbGuarantorDomainMapper
    - Next Step: submissionCallGuarantor

33. **Submission Call Guarantor (submissionCallGuarantor)**
    - Handler: SaveOrUpdateApplicationCallHandler
    - Transitions:
        - On IsGoToSaveAndExit: submissionSaveAndExit
        - On IsEmailVerifiedSuccess: ownership
        - Default: system-down

34. **Ownership (ownership)**
    - Mapper: bbOwnershipDomainMapper
    - Next Step: submissionCallOwnership

35. **Submission Call Ownership (submissionCallOwnership)**
    - Handler: SaveOrUpdateApplicationCallHandler
    - Transitions:
        - On IsGoToSaveAndExit: submissionSaveAndExit
        - Default: authorized-contacts

36. **Authorized Contacts (authorized-contacts)**
    - Mapper: bbAuthContactDomainMapper
    - Next Step: submissionCallAuthContacts

37. **Submission Call Auth Contacts (submissionCallAuthContacts)**
    - Handler: SaveOrUpdateApplicationCallHandler
    - Transitions:
        - On IsGoToSaveAndExit: submissionSaveAndExit
        - Default: locations

38. **Locations (locations)**
    - Mapper: bbLocationsDomainMapper
    - Next Step: submissionCallLocations

39. **Submission Call Locations (submissionCallLocations)**
    - Handler: SaveOrUpdateApplicationCallHandler
    - Transitions:
        - On IsGoToSaveAndExit: submissionSaveAndExit
        - Default: settlement

40. **Settlement (`Sure, let's analyze the flow from one handler to another in the given XML definition.

### Flow Breakdown

1. **Initial Step (init)**
    - Handlers: Loginlaas EventCallHandler, FlowInitializationIaas EventCallHandler
    - Next Step: entitlements

2. **Entitlements (entitlements)**
    - Handler: VerifyUserEntitlementsCallHandler
    - Transitions:
        - On AreParametersInvalid: something-went-wrong
        - On IsExternalCallHandlerFailure: system-down
        - On AreEntitlementsNotAsRequired: invalid-access
        - Default: splash

3. **Splash (splash)**
    - Mapper: bbSplashDomainMapperImpl
    - Transitions:
        - On IsAuthContactsActive: get-authorized-contacts
        - Default: getVerticals

4. **Get Authorized Contacts (get-authorized-contacts)**
    - Handler: ExistingAuthContactsHandler
    - Next Step: getVerticals

5. **Get Verticals (getVerticals)**
    - Handler: VerticalsSessionCallHandler
    - Transitions:
        - On IsExternalCallHandlerFailure: system-down
        - On IsGoTOReviewOrderPage: review-order-session
        - Default: get-started

6. **Review Order Session (review-order-session)**
    - Handlers: ValidateSNRCallHandler, SNRRuleHandler
    - Transitions:
        - On IsNcrProductFeatureEnabled: order-review-rulehandler
        - On IsExternalCallHandlerFailure: system-down
        - Default: review-order

7. **Order Review Rule Handler (order-review-rulehandler)**
    - Handler: RuleHandler
    - Transitions:
        - On IsExternalCallHandlerFailure: system-down
        - Default: review-order

8. **Get Started (get-started)**
    - Mapper: sfGetStartedDomainMapper
    - Next Step: business-questionnaire

9. **Business Questionnaire (business-questionnaire)**
    - Mapper: sfBusinessQuestionnaireDomainMapper
    - Next Step: getPricingOptions

10. **Get Pricing Options (getPricingOptions)**
    - Handler: PricingOptionSessionCallHandler
    - Transitions:
        - On IsExternalCallHandlerFailure: system-down
        - Default: pricing-options

11. **Pricing Options (pricing-options)**
    - Mapper: sfPricingOptionDomainMapper
    - Next Step: getEProductData

12. **Get EProduct Data (getEProductData)**
    - Handler: EProductBundleCallHandler
    - Transitions:
        - On IsExternalCallHandlerFailure: system-down
        - Default: return-bundle-options

13. **Return Bundle Options (return-bundle-options)**
    - Mapper: sfReturnBundleOptionDomainMapper
    - Transitions:
        - On IsBYOBFlow: retrieve-software-list
        - Default: bundle-details

14. **Retrieve Software List (retrieve-software-list)**
    - Handler: RetrieveSoftwareListCallHandler
    - Transitions:
        - On IsExternalCallHandlerFailure: system-down
        - Default: byob-software

15. **BYOB Software (byob-software)**
    - Mapper: sfByobSoftwareDomainMapper
    - Transitions:
        - On IsGoToByobSoftwareFlow: byob-software
        - On IsKdsEnabled: byob-vas-and-cds
        - Default: byob-value-added-services

16. **BYOB Value-Added Services (byob-value-added-services)**
    - Mapper: sfByobValueAddedServiceDomainMapper
    - Next Step: byob-peripherals

17. **BYOB VAS and CDS (byob-vas-and-cds)**
    - Mapper: sfByobVasAndCdsDomainMapper
    - Next Step: byob-peripherals

18. **BYOB Peripherals (byob-peripherals)**
    - Mapper: sfByobPeripheralsDomainMapper
    - Next Step: byob-hardware-peripherals

19. **BYOB Hardware Peripherals (byob-hardware-peripherals)**
    - Mapper: sfByobHardwarePeripheralsDomainMapper
    - Next Step: byob-accessories

20. **BYOB Accessories (byob-accessories)**
    - Mapper: sfByobAccessoryDomainMapper
    - Transitions:
        - On IsNcrProductFeatureEnabled: product-rules
        - Default: payment-configurations-session

21. **Bundle Details (bundle-details)**
    - Mapper: sfBundleDetailsDomainMapper
    - Transitions:
        - On IsNcrProductFeatureEnabled: product-rules
        - Default: payment-configurations-session

22. **Product Rules (product-rules)**
    - Handler: RuleHandler
    - Next Step: payment-configurations-session

23. **Payment Configurations Session (payment-configurations-session)**
    - Handler: PaymentConfigurationsSessionCallHandler
    - Transitions:
        - On IsExternalCallHandlerFailure: system-down
        - Default: payment-configurations

24. **Payment Configurations (payment-configurations)**
    - Mapper: sfPaymentConfigurationDomainMapper
    - Next Step: review-order

25. **Review Order (review-order)**
    - Mapper: bbPCReviewOrderDomainMapper
    - Transitions:
        - On IsGoToExit: save-and-exit
        - On IsGoToRemoveLocationFlow: review-order
        - On IsGoToChangeVerticalFlow: get-started
        - On IsGoToEditSolutionOrAddLocationFlow: business-questionnaire
        - On IsMaxHardwareOrPeripherals: review-order
        - On IsAnyLocationHavingInvalidData: review-order
        - Default: submissionCallProductCatalogReviewOrder

26. **Submission Call Product Catalog Review Order (submissionCallProductCatalogReviewOrder)**
    - Handlers: SaveOrUpdateApplicationCallHandler, StartCEHEventCallHandler
    - Transitions:
        - On IsGoToSaveAndExit: submissionSaveAndExit
        - On IsVerifyEmailEnabled: fetchAuthHubValidationTokenForBusinessEmail
        - Default: business-overview

27. **Business Overview (business-overview)**
    - Mapper: bbBusinessOverviewDomainMapper
    - Next Step: submissionCallBusinessOverview

28. **Submission Call Business Overview (submissionCallBusinessOverview)**
    - Handler: SaveOrUpdateApplicationCallHandler
    - Transitions:
        - On IsGoToSaveAndExit: submissionSaveAndExit
        - On IsEmailVerifiedSuccess: business-activities
        - Default: system-down

29. **Business Activities (business-activities)**
    - Mapper: sfBusinessActivityDomainMapper
    - Next Step: submissionCallBusinessActivities

30. **Submission Call Business Activities (submissionCallBusinessActivities)**
    - Handler: SaveOrUpdateApplicationCallHandler
    - Transitions:
        - On IsGoToSaveAndExit: submissionSaveAndExit
        - On IsVerifyEmailOrNCRMobileEnabledAndGuarantorPresent: fetchAuthHubValidationTokenForGuarantorEmail
        - Default: applicant

31. **Fetch Auth Hub Validation Token for Guarantor Email (fetchAuthHubValidationTokenForGuarantorEmail)**
    - Handler: GuarantorCreateAuthHubOTTCallHandler
    - Next Step: applicant

32. **Applicant (applicant)**
    - Mapper: bbGuarantorDomainMapper
    - Next Step: submissionCallGuarantor

33. **Submission Call Guarantor (submissionCallGuarantor)**
    - Handler: SaveOrUpdateApplicationCallHandler
    - Transitions:
        - On IsGoToSaveAndExit: submissionSaveAndExit
        - On IsEmailVerifiedSuccess: ownership
        - Default: system-down

34. **Ownership (ownership)**
    - Mapper: bbOwnershipDomainMapper
    - Next Step: submissionCallOwnership

35. **Submission Call Ownership (submissionCallOwnership)**
    - Handler: SaveOrUpdateApplicationCallHandler
    - Transitions:
        - On IsGoToSaveAndExit: submissionSaveAndExit
        - Default: authorized-contacts

36. **Authorized Contacts (authorized-contacts)**
    - Mapper: bbAuthContactDomainMapper
    - Next Step: submissionCallAuthContacts

37. **Submission Call Auth Contacts (submissionCallAuthContacts)**
    - Handler: SaveOrUpdateApplicationCallHandler
    - Transitions:
        - On IsGoToSaveAndExit: submissionSaveAndExit
        - Default: locations

38. **Locations (locations)**
    - Mapper: bbLocationsDomainMapper
    - Next Step: submissionCallLocations

39. **Submission Call Locations (submissionCallLocations)**
    - Handler: SaveOrUpdateApplicationCallHandler
    - Transitions:
        - On IsGoToSaveAndExit: submissionSaveAndExit
        - Default: settlement


40. **Settlement (settlement)**
    - Mapper: sfSettlementDomainMapper
    - Next Step: submissionCallSettlement

41. **Submission Call Settlement (submissionCallSettlement)**
    - Handler: SaveOrUpdateApplicationCallHandler
    - Transitions:
        - On IsGoToSaveAndExit: submissionSaveAndExit
        - Default: retrieve-shipping-details

42. **Retrieve Shipping Details (retrieve-shipping-details)**
    - Handler: RetrieveShippingDetailsCallHandler
    - Transitions:
        - On IsExternalCallHandlerFailure: system-down
        - Default: application-review-order

43. **Application Review Order (application-review-order)**
    - Mapper: sfApplicationReviewOrderDomainMapper
    - Next Step: submissionApplicationReviewOrder

44. **Submission Application Review Order (submissionApplicationReviewOrder)**
    - Handler: SaveOrUpdateApplicationCallHandler
    - Transitions:
        - On IsGoToReferToSpecialist: screener-questions
        - On IsGoToSaveAndExit: submissionSaveAndExit
        - Default: disclosure

45. **Disclosure (disclosure)**
    - Mapper: sfDisclosureDomainMapper
    - Next Step: submissionCallFinal

46. **Submission Call Final (submissionCallFinal)**
    - Handler: SaveOrUpdateApplicationCallHandler
    - Transitions:
        - On IsGoToSaveAndExit: submissionSaveAndExit
        - Default: submitApplication

47. **Submit Application (submitApplication)**
    - Handler: SubmitApplicationCallHandler
    - Transitions:
        - On IsExternalCallHandlerFailure: system-down
        - Default: waiting-screen

48. **Waiting Screen (waiting-screen)**
    - Mapper: waitingScreenDomainMapper
    - Next Step: applicationSubmittedHandler

49. **Application Submitted Handler (applicationSubmittedHandler)**
    - Handlers: ExpirePreviousActiveOrderForMerchantHandler, SubmitCEHEventCallHandler, CloseApplicationCallHandler
    - Next Step: application-submitted

50. **Application Submitted (application-submitted)**
    - Mapper: applicationSubmittedDomainMapper
    - End of flow.

### Common Routes Definition

1. **Submission Save and Exit (submissionSaveAndExit)**
    - Handlers: SaveCEHEventCallHandler, CNESavedAppEmailCallHandler
    - Next Step: save-and-exit

The flow proceeds sequentially through various steps, where each step can have multiple transitions based on rules. The transitions dictate the next step in the process, ensuring a dynamic flow based on different conditions.`
