# goog-define-bug

Demonstrates a bug in ClojureScript/cljsbuild's implementation of `goog-define` plus `:closure-defines` override.

The source is just a trivial piece of ClojureScript that logs a message containing a `goog-define`d var.

Four build profiles are defined, one for each optimization type, and each sets that var to the name of the optimization type. For `:none` and `:whitespace` optimizations, the `goog-define` mechanism doesn't appear to work. For `:none`, adding a `:main` entrypoint to the compiler options seems to fix the issue, but not for `:whitespace`.

So far, tested with CLJS `1.7.122` and cljsbuild `1.0.6`.
## Usage

```bash
lein cljsbuild once none whitespace simple advanced
open resources/public/index.html
```

Open the JS console. On the main page you should see three messages. Expected:

```
optimization type is whitespace
optimization type is simple
optimization type is advanced
```

Actual:

```
optimization type is opt-type define not set
optimization type is simple
optimization type is advanced
```

Likewise, the sub-page for "none" optimization also gives "not set" instead of "none" _if_ the `:main` option is not set in the cljsbuild options.

## License

Copyright © 2015 Christopher Vermilion

Distributed under the Eclipse Public License, the same as Clojure.
