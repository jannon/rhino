/* -*- Mode: java; tab-width: 8; indent-tabs-mode: nil; c-basic-offset: 4 -*-
 *
 * The contents of this file are subject to the Netscape Public
 * License Version 1.1 (the "License"); you may not use this file
 * except in compliance with the License. You may obtain a copy of
 * the License at http://www.mozilla.org/NPL/
 *
 * Software distributed under the License is distributed on an "AS
 * IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or
 * implied. See the License for the specific language governing
 * rights and limitations under the License.
 *
 * The Original Code is Rhino code, released
 * May 6, 1999.
 *
 * The Initial Developer of the Original Code is Netscape
 * Communications Corporation.  Portions created by Netscape are
 * Copyright (C) 1997-1999 Netscape Communications Corporation. All
 * Rights Reserved.
 *
 * Contributor(s):
 * Norris Boyd
 *
 * Alternatively, the contents of this file may be used under the
 * terms of the GNU Public License (the "GPL"), in which case the
 * provisions of the GPL are applicable instead of those above.
 * If you wish to allow use of your version of this file only
 * under the terms of the GPL and not to allow others to use your
 * version of this file under the NPL, indicate your decision by
 * deleting the provisions above and replace them with the notice
 * and other provisions required by the GPL.  If you do not delete
 * the provisions above, a recipient may use your version of this
 * file under either the NPL or the GPL.
 */

package org.mozilla.javascript;

/**
@deprecated Since Rhino 1.5 R4 this interface is split into {@link ClassShutter} interface with the single {@link ClassShutter#visibleToScripts(String fullClassName)} method and the abstract {@link SecurityController} class to implement domain-based security restrictions.
<p>
For binary compatibility with older code implementing SecuritySupport only to restrict class access via the visibleToScripts method, this interface extends {@link ClassShutter}, so to upgrade you code in this case simply replace SecuritySupport by ClassShutter and remove empty implementation of the defineClass, getClassContext and getSecurityDomain methods. Then call {@link Context#setClassShutter(ClassShutter)} in place of{@link Context#setSecuritySupport(SecuritySupport)}.
<p>
The new {@link SecurityController} is incompatible with the old security implementation, so if you previously had non-trivial implementation of the defineClass, getClassContext and getSecurityDomain methods, you need to upgrade you code to use the new {@link SecurityController}.
*/
public interface SecuritySupport extends ClassShutter {

    public boolean visibleToScripts(String fullClassName);
}