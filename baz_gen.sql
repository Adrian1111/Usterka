SET NOCOUNT ON;
GO

CREATE DATABASE [ZGLASZANIE_USTEREK]
GO

USE [master]
GO
ALTER DATABASE [ZGLASZANIE_USTEREK] SET RECOVERY FULL WITH NO_WAIT
GO

USE [ZGLASZANIE_USTEREK]
GO


--------------------------------
-- TABLES
--------------------------------

create table Klient (
[ID] [int] NOT NULL PRIMARY KEY IDENTITY(1,1),
full_name					    varchar(255),
email							varchar(255),
[InsertDateTime] [datetime] NOT NULL CONSTRAINT "ConGetDate_Klient" DEFAULT GETDATE()
);
CREATE INDEX index_Klient_InsertDateTime ON Klient (InsertDateTime)
GO

create table Zgloszenie (
[ID] [int] NOT NULL PRIMARY KEY IDENTITY(1,1),
pucharse_no					        char(10),
client_id							int NOT NULL FOREIGN KEY REFERENCES Klient(ID) ON DELETE CASCADE ON UPDATE CASCADE,
[InsertDateTime] [datetime] NOT NULL CONSTRAINT "ConGetDate_Zgloszenie" DEFAULT GETDATE()
);
CREATE INDEX index_Zgloszenie_InsertDateTime ON Zgloszenie (InsertDateTime)
GO

create table Kategoria (
[ID] [int] NOT NULL PRIMARY KEY IDENTITY(1,1),
name                        varchar(255),
parent_category_id          int NOT NULL FOREIGN KEY REFERENCES Kategoria(ID) ON DELETE NO ACTION ON UPDATE NO ACTION,
);
GO

create table Rodzaj_usterki (
[ID] [int] NOT NULL PRIMARY KEY IDENTITY(1,1),
pucharse_id					        int NOT NULL FOREIGN KEY REFERENCES Zgloszenie(ID) ON DELETE CASCADE ON UPDATE CASCADE,
category_id							int NOT NULL FOREIGN KEY REFERENCES Kategoria(ID) ON DELETE CASCADE ON UPDATE CASCADE,
name                                varchar(255),
descriptionOf                       varchar(1000),
);
GO



--------------------------------
-- END OF TABLES
---------------------------------
