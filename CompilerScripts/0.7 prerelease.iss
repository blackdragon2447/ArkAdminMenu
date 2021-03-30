; Script generated by the Inno Setup Script Wizard.
; Script generated by the Inno Setup Script Wizard.
; SEE THE DOCUMENTATION FOR DETAILS ON CREATING INNO SETUP SCRIPT FILES!

#define MyAppName "Ark Admin Manager"
#define MyAppVersion "0.7 - prerelease"
#define MyAppPublisher "BlackDragon2447"
#define MyAppExeName "run.bat"

[Setup]
; NOTE: The value of AppId uniquely identifies this application. Do not use the same AppId value in installers for other applications.
; (To generate a new GUID, click Tools | Generate GUID inside the IDE.)
AppId={{93BF6E04-2B57-4B48-8AB7-468D72F33280}
AppName={#MyAppName}
AppVersion={#MyAppVersion}
;AppVerName={#MyAppName} {#MyAppVersion}
AppPublisher={#MyAppPublisher}
DefaultDirName={autopf}\{#MyAppName}
DisableProgramGroupPage=yes
LicenseFile=C:\Users\thoma\Desktop\java workspace\ArkAdminMenu\AAM 0.7 - prerelease\license.txt
; Uncomment the following line to run in non administrative install mode (install for current user only.)
;PrivilegesRequired=lowest
PrivilegesRequiredOverridesAllowed=dialog
OutputBaseFilename=AAMSetup
Compression=lzma
SolidCompression=yes
WizardStyle=modern

[Languages]
Name: "english"; MessagesFile: "compiler:Default.isl"

[Tasks]
Name: "desktopicon"; Description: "{cm:CreateDesktopIcon}"; GroupDescription: "{cm:AdditionalIcons}"; Flags: unchecked

[Dirs]
Name: "{app}";  Permissions: everyone-full

[Files]
Source: "C:\Users\thoma\Desktop\java workspace\ArkAdminMenu\AAM 0.7 - prerelease\{#MyAppExeName}"; DestDir: "{app}"; Flags: ignoreversion;   Permissions: everyone-full
Source: "C:\Users\thoma\Desktop\java workspace\ArkAdminMenu\AAM 0.7 - prerelease\*"; DestDir: "{app}"; Flags: ignoreversion recursesubdirs createallsubdirs;   Permissions: everyone-full
Source: "jre-8u281-windows-x64.exe"; DestDir: "{tmp}"; DestName: "JREInstall.exe"; Check: IsWin64 AND InstallJava();
Source: "jre-8u281-windows-i586-iftw.exe"; DestDir: "{tmp}"; DestName: "JREInstall.exe"; Check: (NOT IsWin64) AND InstallJava();
; NOTE: Don't use "Flags: ignoreversion" on any shared system files

[Icons]
Name: "{autoprograms}\{#MyAppName}"; Filename: "{app}\{#MyAppExeName}"
Name: "{autodesktop}\{#MyAppName}"; Filename: "{app}\{#MyAppExeName}"; Tasks: desktopicon

[Run]
Filename: "{app}\{#MyAppExeName}"; Description: "{cm:LaunchProgram,{#StringChange(MyAppName, '&', '&&')}}"; Flags: nowait postinstall skipifsilent 


[Code]
var
  UserPage: TInputQueryWizardPage;

procedure InitializeWizard;
begin
//  UserPage := CreateInputQueryPage(wpWelcome,
//    'logging data', 'This data is used to log what admin run a command',
//    'Please specify a client name name');
//  UserPage.Add('Name:', False);
//  UserPage.Add('Password:', True);
end;

function GetUser(Param: String): String;
begin
  if Param = 'Name' then
    Result := UserPage.Values[0]
  else if Param = 'Password' then
    Result := GetSHA256OfUnicodeString(UserPage.Values[1]);
end;

procedure DecodeVersion(verstr: String; var verint: array of Integer);
var
  i,p: Integer; s: string;
begin
  { initialize array }
  verint := [0,0,0,0];
  i := 0;
  while ((Length(verstr) > 0) and (i < 4)) do
  begin
    p := pos ('.', verstr);
    if p > 0 then
    begin
      if p = 1 then s:= '0' else s:= Copy (verstr, 1, p - 1);
      verint[i] := StrToInt(s);
      i := i + 1;
      verstr := Copy (verstr, p+1, Length(verstr));
    end
    else
    begin
      verint[i] := StrToInt (verstr);
      verstr := '';
    end;
  end;
end;

function CompareVersion (ver1, ver2: String) : Integer;
var
  verint1, verint2: array of Integer;
  i: integer;
begin
  SetArrayLength (verint1, 4);
  DecodeVersion (ver1, verint1);

  SetArrayLength (verint2, 4);
  DecodeVersion (ver2, verint2);

  Result := 0; i := 0;
  while ((Result = 0) and ( i < 4 )) do
  begin
    if verint1[i] > verint2[i] then
      Result := 1
    else
      if verint1[i] < verint2[i] then
        Result := -1
      else
        Result := 0;
    i := i + 1;
  end;
end;

function InstallJava() : Boolean;
var
  ErrCode: Integer;
  JVer: String;
  InstallJ: Boolean;
begin
  RegQueryStringValue(
    HKLM, 'SOFTWARE\JavaSoft\Java Runtime Environment', 'CurrentVersion', JVer);
  InstallJ := true;
  if Length( JVer ) > 0 then
  begin
    if CompareVersion(JVer, '1.8') >= 0 then
    begin
      InstallJ := false;
    end;
  end;
  Result := InstallJ;
end;
