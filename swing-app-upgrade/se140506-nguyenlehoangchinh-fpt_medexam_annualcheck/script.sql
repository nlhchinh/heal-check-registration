USE [master]
GO
/****** Object:  Database [Registration_Information]    Script Date: 11/03/2023 11:08:13 SA ******/
CREATE DATABASE [Registration_Information]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'Registration_Information', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.MSSQLSERVER\MSSQL\DATA\Registration_Information.mdf' , SIZE = 3072KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'Registration_Information_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.MSSQLSERVER\MSSQL\DATA\Registration_Information_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [Registration_Information] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [Registration_Information].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [Registration_Information] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [Registration_Information] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [Registration_Information] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [Registration_Information] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [Registration_Information] SET ARITHABORT OFF 
GO
ALTER DATABASE [Registration_Information] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [Registration_Information] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [Registration_Information] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [Registration_Information] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [Registration_Information] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [Registration_Information] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [Registration_Information] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [Registration_Information] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [Registration_Information] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [Registration_Information] SET  DISABLE_BROKER 
GO
ALTER DATABASE [Registration_Information] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [Registration_Information] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [Registration_Information] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [Registration_Information] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [Registration_Information] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [Registration_Information] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [Registration_Information] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [Registration_Information] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [Registration_Information] SET  MULTI_USER 
GO
ALTER DATABASE [Registration_Information] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [Registration_Information] SET DB_CHAINING OFF 
GO
ALTER DATABASE [Registration_Information] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [Registration_Information] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [Registration_Information] SET DELAYED_DURABILITY = DISABLED 
GO
USE [Registration_Information]
GO
/****** Object:  Table [dbo].[TblCheckList]    Script Date: 11/03/2023 11:08:13 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TblCheckList](
	[itemID] [nvarchar](10) NOT NULL,
	[itemName] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_TblCheckList] PRIMARY KEY CLUSTERED 
(
	[itemID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[TblCheckListManagement]    Script Date: 11/03/2023 11:08:13 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TblCheckListManagement](
	[id] [nvarchar](10) NOT NULL,
	[employeeID] [nvarchar](10) NOT NULL,
	[itemID] [nvarchar](10) NOT NULL,
	[status] [nvarchar](10) NOT NULL,
 CONSTRAINT [PK_TblCheckListManagement] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[TblEmployee]    Script Date: 11/03/2023 11:08:13 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TblEmployee](
	[employeeID] [nvarchar](10) NOT NULL,
	[fullName] [nvarchar](50) NOT NULL,
	[birthday] [date] NOT NULL,
	[gender] [bit] NOT NULL,
	[email] [nvarchar](50) NOT NULL,
	[phone] [nvarchar](50) NOT NULL,
	[department] [nvarchar](50) NOT NULL,
	[address] [nvarchar](max) NOT NULL,
 CONSTRAINT [PK_TblEmployee] PRIMARY KEY CLUSTERED 
(
	[employeeID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
INSERT [dbo].[TblCheckList] ([itemID], [itemName]) VALUES (N'1', N'Physical exam')
INSERT [dbo].[TblCheckList] ([itemID], [itemName]) VALUES (N'2', N'Eye exam')
INSERT [dbo].[TblCheckList] ([itemID], [itemName]) VALUES (N'3', N'Chest X-ray')
INSERT [dbo].[TblCheckList] ([itemID], [itemName]) VALUES (N'4', N'Blood count and chemistry')
INSERT [dbo].[TblCheckList] ([itemID], [itemName]) VALUES (N'5', N'Dermatology')
INSERT [dbo].[TblCheckList] ([itemID], [itemName]) VALUES (N'6', N'Dental exam')
INSERT [dbo].[TblCheckList] ([itemID], [itemName]) VALUES (N'7', N'Stomach ultrasound')
INSERT [dbo].[TblCheckList] ([itemID], [itemName]) VALUES (N'8', N'Electrocardiogram')
INSERT [dbo].[TblCheckListManagement] ([id], [employeeID], [itemID], [status]) VALUES (N'130', N'TEST22', N'1', N'checked')
INSERT [dbo].[TblCheckListManagement] ([id], [employeeID], [itemID], [status]) VALUES (N'131', N'TEST22', N'2', N'uncheck')
INSERT [dbo].[TblCheckListManagement] ([id], [employeeID], [itemID], [status]) VALUES (N'132', N'TEST22', N'3', N'uncheck')
INSERT [dbo].[TblCheckListManagement] ([id], [employeeID], [itemID], [status]) VALUES (N'133', N'TEST22', N'4', N'uncheck')
INSERT [dbo].[TblCheckListManagement] ([id], [employeeID], [itemID], [status]) VALUES (N'134', N'TEST22', N'5', N'uncheck')
INSERT [dbo].[TblCheckListManagement] ([id], [employeeID], [itemID], [status]) VALUES (N'135', N'TEST22', N'6', N'uncheck')
INSERT [dbo].[TblCheckListManagement] ([id], [employeeID], [itemID], [status]) VALUES (N'136', N'TEST22', N'7', N'uncheck')
INSERT [dbo].[TblCheckListManagement] ([id], [employeeID], [itemID], [status]) VALUES (N'137', N'TEST22', N'8', N'uncheck')
INSERT [dbo].[TblCheckListManagement] ([id], [employeeID], [itemID], [status]) VALUES (N'138', N'TEST33', N'1', N'checked')
INSERT [dbo].[TblCheckListManagement] ([id], [employeeID], [itemID], [status]) VALUES (N'139', N'TEST33', N'2', N'checked')
INSERT [dbo].[TblCheckListManagement] ([id], [employeeID], [itemID], [status]) VALUES (N'140', N'TEST33', N'3', N'unchecked')
INSERT [dbo].[TblCheckListManagement] ([id], [employeeID], [itemID], [status]) VALUES (N'141', N'TEST33', N'4', N'unchecked')
INSERT [dbo].[TblCheckListManagement] ([id], [employeeID], [itemID], [status]) VALUES (N'142', N'TEST33', N'5', N'unchecked')
INSERT [dbo].[TblCheckListManagement] ([id], [employeeID], [itemID], [status]) VALUES (N'143', N'TEST33', N'6', N'unchecked')
INSERT [dbo].[TblCheckListManagement] ([id], [employeeID], [itemID], [status]) VALUES (N'144', N'TEST33', N'7', N'checked')
INSERT [dbo].[TblCheckListManagement] ([id], [employeeID], [itemID], [status]) VALUES (N'145', N'TEST33', N'8', N'checked')
INSERT [dbo].[TblCheckListManagement] ([id], [employeeID], [itemID], [status]) VALUES (N'146', N'TEST44', N'1', N'checked')
INSERT [dbo].[TblCheckListManagement] ([id], [employeeID], [itemID], [status]) VALUES (N'147', N'TEST44', N'2', N'unchecked')
INSERT [dbo].[TblCheckListManagement] ([id], [employeeID], [itemID], [status]) VALUES (N'148', N'TEST44', N'3', N'unchecked')
INSERT [dbo].[TblCheckListManagement] ([id], [employeeID], [itemID], [status]) VALUES (N'149', N'TEST44', N'4', N'unchecked')
INSERT [dbo].[TblCheckListManagement] ([id], [employeeID], [itemID], [status]) VALUES (N'150', N'TEST44', N'5', N'unchecked')
INSERT [dbo].[TblCheckListManagement] ([id], [employeeID], [itemID], [status]) VALUES (N'151', N'TEST44', N'6', N'checked')
INSERT [dbo].[TblCheckListManagement] ([id], [employeeID], [itemID], [status]) VALUES (N'152', N'TEST44', N'7', N'unchecked')
INSERT [dbo].[TblCheckListManagement] ([id], [employeeID], [itemID], [status]) VALUES (N'153', N'TEST44', N'8', N'unchecked')
INSERT [dbo].[TblEmployee] ([employeeID], [fullName], [birthday], [gender], [email], [phone], [department], [address]) VALUES (N'TEST22', N'nguyen le hoang chinh', CAST(N'1999-01-02' AS Date), 0, N'chinhnguyen16@gmail.com', N'0328802216', N'Information Technology', N'123abc')
INSERT [dbo].[TblEmployee] ([employeeID], [fullName], [birthday], [gender], [email], [phone], [department], [address]) VALUES (N'TEST33', N'tran hoan', CAST(N'2001-03-15' AS Date), 1, N'hoan@gmail.com', N'029384718294', N'Business Administration', N'testing delete')
INSERT [dbo].[TblEmployee] ([employeeID], [fullName], [birthday], [gender], [email], [phone], [department], [address]) VALUES (N'TEST44', N'ma dai hung', CAST(N'1990-03-14' AS Date), 1, N'hung@gmail.com', N'0394875566', N'Business Administration', N'testing')
ALTER TABLE [dbo].[TblCheckListManagement]  WITH CHECK ADD  CONSTRAINT [fk_employee_id] FOREIGN KEY([employeeID])
REFERENCES [dbo].[TblEmployee] ([employeeID])
GO
ALTER TABLE [dbo].[TblCheckListManagement] CHECK CONSTRAINT [fk_employee_id]
GO
ALTER TABLE [dbo].[TblCheckListManagement]  WITH CHECK ADD  CONSTRAINT [fk_item_id] FOREIGN KEY([itemID])
REFERENCES [dbo].[TblCheckList] ([itemID])
GO
ALTER TABLE [dbo].[TblCheckListManagement] CHECK CONSTRAINT [fk_item_id]
GO
USE [master]
GO
ALTER DATABASE [Registration_Information] SET  READ_WRITE 
GO
