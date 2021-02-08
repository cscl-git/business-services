ALTER TABLE public.eg_hrms_employee ADD hrms_code varchar(15) NULL;
ALTER TABLE public.eg_hrms_employee ADD postdetailid int4 NULL;
ALTER TABLE public.eg_hrms_employee ADD CONSTRAINT eg_hrms_employee_un_hrms_code UNIQUE (hrms_code);
