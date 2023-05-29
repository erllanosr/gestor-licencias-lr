create table licencias (
	uuid_ VARCHAR(75) null,
	licenciasId LONG not null primary key,
	nombreLicencia VARCHAR(75) null,
	descripcionLicencia VARCHAR(75) null,
	versionLicencia VARCHAR(75) null,
	userId LONG
);