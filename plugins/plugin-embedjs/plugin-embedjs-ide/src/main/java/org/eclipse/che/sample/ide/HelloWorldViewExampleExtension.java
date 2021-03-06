/*
 * Copyright (c) 2012-2018 Red Hat, Inc.
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.che.sample.ide;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.eclipse.che.ide.api.action.ActionManager;
import org.eclipse.che.ide.api.action.DefaultActionGroup;
import org.eclipse.che.ide.api.extension.Extension;
import org.eclipse.che.sample.ide.action.HelloWorldAction;

/** @author Mathias Schaefer <mathias.schaefer@eclipsesource.com> */
@Extension(title = "Hello world from JavaScript example")
@Singleton
public class HelloWorldViewExampleExtension {

  @Inject
  private void configureActions(
      final ActionManager actionManager, final HelloWorldAction helloWorldAction) {

    DefaultActionGroup mainContextMenuGroup =
        (DefaultActionGroup) actionManager.getAction("resourceOperation");
    DefaultActionGroup jsGroup =
        new DefaultActionGroup("JavaScript View Example", true, actionManager);
    mainContextMenuGroup.add(jsGroup);

    actionManager.registerAction(helloWorldAction.ACTION_ID, helloWorldAction);
    jsGroup.addAction(helloWorldAction);
  }
}
