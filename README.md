# isomorphic-node

FIXME: description

## Installation



## Usage

You will need to install node.js and then install express and
serve-static from within the project directory.

    $ npm install express --save
    $ npm install serve-static --save

Once you have these installed you can build and run the app using:

    $ lein cljsbuild once server app
    $ node resources/public/js/server-side/server.js



## Development

### Using Figwheel

You can run Figwheel either from the REPL or from 'lein figwheel'. The
recommended approach is via the REPL.

##### Using CIDER in Emacs

Start a CIDER nREPL server and two nREPL buffers (one for Clojure and
one for ClojureScript) by using:

``` emacs-lisp
C-c M-J
```
*Note* the capital 'J'

or:

``` emacs-lisp
M-x cider-jack-in-clojurescript
```

Once the buffers are started you can switch to the CLJS buffer and
exit the Rhino cljs repl and connect to the app build running in the
browser (make sure you run node and connect a browser):

``` clojure
cljs.user> :cljs/quit
user> (use 'figwheel-sidecar.repl-api)
nil
user> (start-figwheel!)
... _starts app build by default as it's first in project.clj_
...
nil
user> (cljs-repl)
Launching ClojureScript REPL for build: app ...
nil
cljs.user>
```

This CLJS buffer will now be connected to the browser. To connect a
buffer to the server as well.

``` emacs-lisp
M-x cider-connect
localhost
<port for nREPL server - see nrepl-server buffer
```

``` clojure
user> (use 'figwheel-sidecar.repl-api)
nil
user> (switch-to-build "server")
user> (cljs-repl)
Launching ClojureScript REPL for build: server...
nil
cljs.user>
```

This new buffer is now connected to the server running in node.

## Examples

...

### Bugs

...

### Any Other Sections
### That You Think
### Might be Useful

## License

Copyright © 2016 FIXME

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
